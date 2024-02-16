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
import java.util.Map;

public class PatientDAOImpl implements PatientDAO {
    public static final String SQL_SELECT_ALL = "SELECT * FROM patient";
    private static final String SQL_SELECT_ID = "SELECT * FROM patient WHERE id = ?";
    private static final String SQL_ADD = "INSERT INTO patient (vorname, nachname, alter, geschlecht, raum, allergen) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE patient SET vorname = ?, nachname = ?, alter = ?, geschlecht = ?, raum = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM patient WHERE id = ?";

    DBConnection dbcon = new DBConnection();
    private static String TAB_ID = "id";
    private static String TAB_VORNAME = "vorname";
    private static String TAB_NACHNAME = "nachname";
    private static String TAB_ALTER = "alter";
    private static String TAB_GESCHLECHT = "geschlecht";
    private static String TAB_RAUM = "raum";
    private static String TAB_ALLERGIE = "allergie";


    public List<Patient> getAllPatients() {
        List<Patient> patienten = new ArrayList<>();

        try (Connection connection = dbcon.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {

                        Map<String, Class<Allergen>> Allergen;
                        Patient patient = new Patient(
                                resultSet.getInt(TAB_ID),
                                resultSet.getString(TAB_VORNAME),
                                resultSet.getString(TAB_NACHNAME),
                                resultSet.getInt(TAB_ALTER),
                                resultSet.getString(TAB_RAUM)
                                //          resultSet.getObject(TAB_ALLERGIE, Allergen)
                        );
                        patienten.add(patient);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler beim holen der Patientenaufzählung");
        }

        return patienten;
    }


    public Patient getPatientByID(int id) {
        String vorname = null;
        String nachname = null;
        int alter = 0;
        String geschlecht = null;
        String raum = null;
        String allergie = null;

        try (Connection connection = dbcon.getConnection()) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        vorname = resultSet.getString(TAB_VORNAME);
                        nachname = resultSet.getString(TAB_NACHNAME);
                        alter = resultSet.getInt(TAB_ALTER);
                        geschlecht = resultSet.getString(TAB_GESCHLECHT);
                        raum = resultSet.getString(TAB_RAUM);
//                        allergie = resultSet.getString(TAB_ALLERGIE);
                        return new Patient(id, vorname, nachname, alter, raum);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler bei Suche über ID");
        }

        return null;
    }


    public void savePatient(Patient patient) {

    }


    public List<Patient> suchenPatient(String suchBegriff) {
        return null;
    }


    public void addPatient(Patient patient) {
        try (Connection connection = dbcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD)) {
            preparedStatement.setString(1, patient.getVname());
            preparedStatement.setString(2, patient.getNname());
            preparedStatement.setInt(3, patient.getAlter());
            preparedStatement.setString(5, patient.getPatientRaum());
//            preparedStatement.setString(6, patient.getPatientAllergene());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Fehler bei Hinzufügen des Patienten");
        }
        System.out.println(patient.getVname() + " " + patient.getNname() + " hinzugefügt");

    }


    public void updatePatient(Patient updatedPatient) {
        try (Connection connection = dbcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, updatedPatient.getVname());
            preparedStatement.setString(2, updatedPatient.getNname());
            preparedStatement.setInt(3, updatedPatient.getAlter());
            preparedStatement.setString(5, updatedPatient.getPatientRaum());
            //  preparedStatement.setString(6, updatedPatient.getPatientAllergene());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler beim Updaten von " + updatedPatient.getNname());
        }
        System.out.println(updatedPatient.getVname() + " " + updatedPatient.getNname() + "erfolgreich geändert");
    }


    public void deletePatient(int id) {

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
