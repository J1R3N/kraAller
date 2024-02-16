package de.curelei.kraller.db;

// H2GerichtDAO.java


import de.curelei.kraller.gericht.Gericht;
import de.curelei.kraller.gericht.GerichtDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerichtDAOH2Impl implements GerichtDAO {
    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS gerichte (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM gerichte";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM gerichte WHERE id=?";
    private static final String INSERT_QUERY = "INSERT INTO gerichte (name) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE gerichte SET name=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM gerichte WHERE id=?";

    public GerichtDAOH2Impl() {
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
    public List<Gericht> getAllGerichte() {
        List<Gericht> gerichte = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Gericht gericht = new Gericht();
                gericht.setId(resultSet.getInt("ID"));
                gericht.setBezeichnung(resultSet.getString("NAME"));
                gerichte.add(gericht);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gerichte;
    }

    @Override
    public Gericht getGerichtById(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Gericht gericht = new Gericht();
                    gericht.setId(resultSet.getInt("ID"));
                    gericht.setBezeichnung(resultSet.getString("NAME"));
                    return gericht;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveGericht(Gericht gericht) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, gericht.getBezeichnung());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    gericht.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGericht(Gericht gericht) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {

            statement.setString(1, gericht.getBezeichnung());
            statement.setInt(2, gericht.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGericht(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
