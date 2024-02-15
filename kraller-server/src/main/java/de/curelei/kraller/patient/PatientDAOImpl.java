package de.curelei.kraller.patient;

import de.curelei.kraller.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    private List<Patient> patients;
    private int maxId;
    private static final String INSERT_QUERY = "INSERT INTO patient (name) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM patient";

    public PatientDAOImpl() {
        this.patients = new ArrayList<>();
        this.maxId = 0;
    }

    @Override
    public void save(Patient patient) {
        DBConnection DatabaseConnector;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, patient.getNname());
            statement.executeUpdate();
        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    private void handleSQLException(SQLException e) {
        // Add your specific exception handling logic here
        e.printStackTrace();
    }

    @Override
    public void update(Patient updatedPatient) {
        for (Patient patient : patients) {
            if (patient.getId() == updatedPatient.getId()) {
                patient.setNname(updatedPatient.getNname());
                return;
            }
        }

        throw new RuntimeException("Patient not found for update with ID: " + updatedPatient.getId());
    }

    @Override
    public void delete(int id) {
        patients.removeIf(patient -> patient.getId() == id);
    }

    @Override
    public Patient get(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }

        throw new RuntimeException("Patient not found with ID: " + id);
    }

    @Override
    public List<Patient> search() {
        List<Patient> persons = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("id"));
                patient.setNname(resultSet.getString("name"));
                persons.add(patient);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return persons;
    }

    @Override
    public int getMaxId() {
        return maxId;
    }

    private int getNextId() {
        return ++maxId;
    }
}
