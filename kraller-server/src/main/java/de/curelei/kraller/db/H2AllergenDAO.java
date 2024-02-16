package de.curelei.kraller.db;

// H2AllergenDAO.java

import de.curelei.kraller.allergen.Allergen;
import de.curelei.kraller.allergen.AllergenDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2AllergenDAO implements AllergenDAO {
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS allergene (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM allergene";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM allergene WHERE id=?";
    private static final String INSERT_QUERY = "INSERT INTO allergene (name) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE allergene SET name=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM allergene WHERE id=?";

    public H2AllergenDAO() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Allergen> getAllergenAll() {
        return null;
    }

    @Override
    public List<Allergen> getAllAllergene() {
        List<Allergen> allergene = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Allergen allergen = new Allergen();
                allergen.setId(resultSet.getInt("id"));
                allergen.setBezeichnung(resultSet.getString("bezeichnung"));
                allergene.add(allergen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allergene;
    }

    @Override
    public Allergen getAllergenById(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Allergen allergen = new Allergen();
                    allergen.setId(resultSet.getInt("id"));
                    allergen.setBezeichnung(resultSet.getString("bezeichnung"));
                    return allergen;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveAllergen(Allergen allergen) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, allergen.getBezeichnung());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    allergen.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAllergen(Allergen allergen) {

    }

    @Override
    public void updateAllergen(Allergen allergen) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, allergen.getBezeichnung());
            statement.setInt(2, allergen.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllergen(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
