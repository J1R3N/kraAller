package de.curelei.kraller.allergen;

import de.curelei.kraller.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllergenDAOImpl implements AllergenDAO {

    DBConnection dbcon = new DBConnection();
    private static String TABELLE_ID = "id";
    private static final String TABELLE_BEZEICHNUNG = "allergie";
    private static final String TABELLE_UNTERGRUPPE = "untergruppe";

    @Override
    public List<Allergen> getAll() {
        List<Allergen> allergens = new ArrayList<>();

        try (Connection connection = dbcon.getConnection()) {
            String sqlQuery = "SELECT * FROM Allergie";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Allergen allergen = new Allergen(
                                resultSet.getInt(TABELLE_ID),
                                resultSet.getString(TABELLE_UNTERGRUPPE),
                                resultSet.getString(TABELLE_BEZEICHNUNG)
                        );
                        allergens.add(allergen);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allergens;
    }

    @Override
    public Allergen getById(int id) {
        String untergruppe = null;
        String bezeichnung = null;

        try (Connection connection = dbcon.getConnection()) {
            String sqlQuery = "SELECT * FROM Allergie WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        untergruppe = resultSet.getString(TABELLE_UNTERGRUPPE);
                        bezeichnung = resultSet.getString(TABELLE_BEZEICHNUNG);
                        return new Allergen(id, untergruppe, bezeichnung);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehler bei Suche über ID");
        }

        return null;
    }

    @Override
    public void add(Allergen allergen) {
        try (Connection connection = dbcon.getConnection()) {
            String sqlQuery = "INSERT INTO Allergie (untergruppe, allergie) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, allergen.getUntergruppe());
                preparedStatement.setString(2, allergen.getBezeichnung());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehler bei Hinzufügen der Allergene");
        }
        System.out.println(allergen.getBezeichnung() + " hinzugefügt");
    }

    @Override
    public void update(int id, Allergen updatedAllergen) {
        try (Connection connection = dbcon.getConnection()) {
            String sqlQuery = "UPDATE Allergie SET untergruppe = ?, allergie = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setString(1, updatedAllergen.getUntergruppe());
                preparedStatement.setString(2, updatedAllergen.getBezeichnung());
                preparedStatement.setInt(3, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehler beim Updaten von " + updatedAllergen.getBezeichnung());
        }
        System.out.println(updatedAllergen.getBezeichnung() + "erfolgreich geändert");
    }

    @Override
    public void delete(int id) {
        try (Connection connection = dbcon.getConnection()) {
            String sqlQuery = "DELETE FROM Allergie WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehler beim Löschen mit ID " + id);
        }
        System.out.println(id + " erfolgreich gelöscht");
    }
}