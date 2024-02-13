package de.curelei.kraller.db;

import java.io.File;
import java.sql.*;

public class SqliteMainTester {
    private static final String DB_PATH = System.getProperty("user.home") + "/sqlite/" + "testdb.db";

    public static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS benutzer ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL UNIQUE, "
            + "password TEXT NOT NULL, "
            + "email TEXT NOT NULL UNIQUE"
            + ");";

    public static final String ADD_USER = "INSERT INTO benutzer (name, password, email) VALUES (?,?,?);";

    public SqliteMainTester() throws SQLException {
//        createTables();
        crudTest();
    }

    private void crudTest() {
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(ADD_USER);){
            stmt.setString(1, "Name");
            stmt.setString(2, "geheim");
            stmt.setString(3, "f@kiltz.de");
            stmt.execute();

            try (PreparedStatement stmtSel = con.prepareStatement("select * from benutzer")){
                ResultSet rs = stmtSel.executeQuery();
                while (rs.next()) {
                    System.out.println("Name: "+rs.getString("name"));
                }
            }

            try (Statement stmtDel = con.createStatement()){
                stmtDel.execute("delete from benutzer");
            }


            System.out.println("CRUD ohne U");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        File folder = new File(System.getProperty("user.home") + "/sqlite/");
        folder.mkdir();
        new SqliteMainTester();

    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
    }

    private void createTables() throws SQLException {
        try (Connection con = getConnection();
             Statement stmt = con.createStatement()){

            stmt.execute(CREATE_USER_TABLE);

            System.out.println("Tables created");
        } catch (SQLException e) {
            throw e;
        }
    }

}