package de.curelei.kraller.allergen;

import de.curelei.kraller.KrallerException;
import de.curelei.kraller.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllergenDAOImpl implements AllergenDAO {

    private static final String SQL_SELECT_ALL = "SELECT * FROM Allergie";
    private static final String SQL_SELECT_ID = "SELECT * FROM Allergie WHERE id = ?";
    private static final String SQL_ADD = "INSERT INTO Allergie (untergruppe, allergie) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE Allergie SET untergruppe = ?, allergie = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM Allergie WHERE id = ?";
    DBConnection dbcon = new DBConnection();
    private static String TAB_ID = "id";
    private static final String TAB_BEZEICHNUNG = "allergie";
    private static final String TAB_UNTERGRUPPE = "untergruppe";

    @Override
    public List<Allergen> getAll() {
        List<Allergen> allergens = new ArrayList<>();

        try (Connection connection = dbcon.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Allergen allergen = new Allergen(
                                resultSet.getInt(TAB_ID),
                                resultSet.getString(TAB_UNTERGRUPPE),
                                resultSet.getString(TAB_BEZEICHNUNG)
                        );
                        allergens.add(allergen);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler beim Holen der Allergenaufzählung");
        }

        return allergens;
    }

    @Override
    public Allergen getById(int id) {
        String untergruppe = null;
        String bezeichnung = null;

        try (Connection connection = dbcon.getConnection()) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ID)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        untergruppe = resultSet.getString(TAB_UNTERGRUPPE);
                        bezeichnung = resultSet.getString(TAB_BEZEICHNUNG);
                        return new Allergen(id, untergruppe, bezeichnung);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler bei Suche über ID");
        }

        return null;
    }

    @Override
    public void add(Allergen allergen) {
        try (Connection connection = dbcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD)) {
            preparedStatement.setString(1, allergen.getUntergruppe());
            preparedStatement.setString(2, allergen.getBezeichnung());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Fehler bei Hinzufügen der Allergene");
        }
        System.out.println(allergen.getBezeichnung() + " hinzugefügt");

    }

    @Override
    public void update(int id, Allergen updatedAllergen) {
        try (Connection connection = dbcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, updatedAllergen.getUntergruppe());
            preparedStatement.setString(2, updatedAllergen.getBezeichnung());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new KrallerException("Fehler beim Updaten von " + updatedAllergen.getBezeichnung());
        }
        System.out.println(updatedAllergen.getBezeichnung() + "erfolgreich geändert");
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