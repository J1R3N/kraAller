package de.curelei.kraller.patient;

import de.curelei.kraller.KrallerException;
import de.curelei.kraller.allergen.Allergen;
import de.curelei.kraller.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    public static final String SQL_SELECT_ALL = "select p.id pid, p.NACHNAME, p.vorname, p.alter, p.geschlecht,p.raum, a.id aid,  a.untergruppe, a.BEZEICHNUNG from PATIENT p, Allergie a, PATIENTALLERGIE pa" +
            "where p.id = pa.PATIENT_ID" +
            "AND a.id = pa.ALLERGIE_ID";
    private static final String SQL_SELECT_ID = "select p.NACHNAME, p.vorname, p.alter, p.geschlecht,p.raum, a.untergruppe, a.BEZEICHNUNG from PATIENT p, Allergie a, PATIENTALLERGIE pa\n" +
            "where p.id = pa.PATIENT_ID    \n" +
            "   AND a.id = pa.ALLERGIE_ID AND id = ?";
    private static final String SQL_ADD = "INSERT INTO patient (vorname, nachname, alter, geschlecht, raum) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE patient SET vorname = ?, nachname = ?, alter = ?, geschlecht = ?, raum = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM patient WHERE id = ?";


    DBConnection dbcon = new DBConnection();
    private static String TAB_ID = "pid";
    private static String TAB_VORNAME = "vorname";
    private static String TAB_NACHNAME = "nachname";
    private static String TAB_ALTER = "alter";
    private static String TAB_GESCHLECHT = "geschlecht";
    private static String TAB_RAUM = "raum";
    private static String TAB_AID = "aid";
    private static String TAB_BEZEICHNUNG = "bezeichnung";
    private static String TAB_UNTERGRUPPE = "untergruppe";


    @Override
    public List<Patient> getAll() {
        List<Patient> patienten = new ArrayList<>();


        try (Connection connection = dbcon.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {

                        Patient existingPatient = findPatientById(patienten, resultSet.getInt(TAB_ID));
                        if (existingPatient == null) {
                        Patient patient = new Patient(
                                resultSet.getInt(TAB_ID),
                                resultSet.getString(TAB_VORNAME),
                                resultSet.getString(TAB_NACHNAME),
                                resultSet.getInt(TAB_ALTER),
                                resultSet.getString(TAB_GESCHLECHT),
                                resultSet.getString(TAB_RAUM));

                            patienten.add(patient);
                        }
                        if (resultSet.getInt(TAB_AID) < 0) {
                            Allergen allergie = new Allergen();
                            allergie.setUntergruppe(resultSet.getString(TAB_UNTERGRUPPE));
                            allergie.setBezeichnung(resultSet.getString(TAB_BEZEICHNUNG));
                            assert existingPatient != null;
                            existingPatient.addAllergen(allergie);
                        }

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler beim holen der Patientenaufzählung");
        }

        return patienten;
    }

    private Patient findPatientById(List<Patient> patienten, int id) {
        for (Patient patient : patienten) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public Patient getByID(int id) {
        Patient p = new Patient();
        List<Allergen> allergenList = new ArrayList<>();


        try (Connection connection = dbcon.getConnection()) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        if (p.getId() == 0) {
                            p.setVname(resultSet.getString(TAB_VORNAME));
                            p.setNname(resultSet.getString(TAB_NACHNAME));
                            p.setAlter(resultSet.getInt(TAB_ALTER));
                            p.setGeschlecht(resultSet.getString(TAB_GESCHLECHT));
                            p.setPatientRaum(resultSet.getString(TAB_RAUM));
                        }
                        Allergen allergie = new Allergen();
                        allergie.setUntergruppe(resultSet.getString(TAB_UNTERGRUPPE));
                        allergie.setBezeichnung(resultSet.getString(TAB_BEZEICHNUNG));
                        allergenList.add(allergie);
                    }
                    p.setAllergene(allergenList);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler bei Suche über ID");
        }

        return p;
    }

    @Override
    public List<Patient> findByName(String suchBegriff) {
        return null;
        //TODO
    }

    @Override
    public void save(Patient patient) {
        try (Connection connection = dbcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD)) {
            preparedStatement.setString(1, patient.getVname());
            preparedStatement.setString(2, patient.getNname());
            preparedStatement.setInt(3, patient.getAlter());
            preparedStatement.setString(4, patient.getGeschlecht());
            preparedStatement.setString(5, patient.getPatientRaum());
//            preparedStatement.setString(6, patient.getPatientAllergene());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Fehler bei Hinzufügen des Patienten");
        }
        System.out.println(patient.getVname() + " " + patient.getNname() + " hinzugefügt");

    }

    @Override
    public void update(int id, Patient updatedPatient) {
        try (Connection connection = dbcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, updatedPatient.getVname());
            preparedStatement.setString(2, updatedPatient.getNname());
            preparedStatement.setInt(3, updatedPatient.getAlter());
            preparedStatement.setString(4, updatedPatient.getGeschlecht());
            preparedStatement.setString(5, updatedPatient.getPatientRaum());
            //  preparedStatement.setString(6, updatedPatient.getPatientAllergene());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler beim Updaten von " + updatedPatient.getNname());
        }
        System.out.println(updatedPatient.getVname() + " " + updatedPatient.getNname() + "erfolgreich geändert");
    }

    @Override
    public void delete(int id) {

        try (Connection connection = dbcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler beim Löschen mit ID " + id);
        }
        System.out.println(id + " erfolgreich gelöscht");
    }

}
