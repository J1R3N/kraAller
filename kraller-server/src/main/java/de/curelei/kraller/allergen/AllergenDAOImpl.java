package de.curelei.kraller.allergen;

import de.curelei.kraller.db.H2MainTester;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllergenDAOImpl implements AllergenDAO {
    private List<Allergen> allergens = new ArrayList<>();
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";


    @Override
    public List<Allergen> getAll() {
        List<Allergen> allergien = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM Allergie";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Allergen allergie = new Allergen(
                                resultSet.getInt("id"),
                                resultSet.getString("untergruppe"),
                                resultSet.getString("allergie")
                        );
                        allergien.add(allergie);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allergien;
    }

    @Override
    public Allergen getById(int id) {
        String untergruppe = null;
        String bezeichnung = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM Allergie WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        untergruppe = resultSet.getString("untergruppe");
                        bezeichnung = resultSet.getString("bezeichnung");
                        return new Allergen(id, untergruppe, bezeichnung);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(Allergen allergen) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sqlQuery = "INSERT INTO Allergie (untergruppe, allergie) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, allergen.getUntergruppe());
                preparedStatement.setString(2, allergen.getBezeichnung());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Allergen updatedAllergen) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sqlQuery = "UPDATE Allergie SET untergruppe = ?, allergie = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, updatedAllergen.getUntergruppe());
                preparedStatement.setString(2, updatedAllergen.getBezeichnung());
                preparedStatement.setInt(3, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sqlQuery = "DELETE FROM Allergie WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}