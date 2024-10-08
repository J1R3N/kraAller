package de.curelei.kraller.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2MainTester {
    public H2MainTester() {
    }

    public static void main(String[] a) throws Exception {
        Class.forName("org.h2.Driver");
        readDB();
    }

    public static void readDB() {

        String aTabelle = "Allergie";

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {

            Statement stmt = conn.createStatement();

            String dropA = "DROP TABLE IF EXISTS " + aTabelle;
            stmt.executeUpdate(dropA);

            String createA = "CREATE TABLE IF NOT EXISTS " + aTabelle
                    + "(id INTEGER NOT NULL auto_increment, " +
                    "untergruppe VARCHAR(255), " +
                    "bezeichnung VARCHAR(255), " +
                    "primary key(id))";
            stmt.executeUpdate(createA);

            String insertA = "INSERT INTO " + aTabelle +
                    "(untergruppe, bezeichnung) " +
                    "VALUES('1', 'Nuss')," +
                    "('2', 'Milch')," +
                    "('3', 'Laktose')";
            stmt.executeUpdate(insertA);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String pTabelle = "Patient";

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {

            Statement stmt = conn.createStatement();

            String dropP = "DROP TABLE IF EXISTS " + pTabelle;
            stmt.executeUpdate(dropP);

            String createP = "CREATE TABLE IF NOT EXISTS " + pTabelle
                    + "(id INTEGER NOT NULL auto_increment, " +
                    "vorname VARCHAR(255), " +
                    "nachname VARCHAR(255), " +
                    "alter INTEGER," +
                    "geschlecht VARCHAR(255)," +
                    "raum VARCHAR(255)," +
                    "allergie VARCHAR(255)," +
                    "primary key(id))";
            stmt.executeUpdate(createP);

            String createJPA = "CREATE TABLE PatientAllergie (" +
                    "patient_id INT," +
                    "allergie_id INT," +
                    "PRIMARY KEY (patient_id, allergie_id)," +
                    "FOREIGN KEY (patient_id) REFERENCES Patient(id)," +
                    "FOREIGN KEY (allergie_id) REFERENCES Allergie(id)" +
                    ")";
            stmt.executeUpdate(createJPA);

            String insertP = "INSERT INTO " + pTabelle +
                    "(vorname, nachname, alter, geschlecht, raum, allergie) " +
                    "VALUES('max', 'Nuss', '10', 'm', '301', 'Nuss')," +
                    "('maxi', 'muster', '11', 'm', '302', 'Laktose')";
            stmt.executeUpdate(insertP);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dbconnector(String query) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "")) {

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

