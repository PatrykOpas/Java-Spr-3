package pl.lublin.wsei.java.cwiczenia.MyDB.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.*;

public class MyDB {
    private Connection conn = null;
    private String user = "";
    private String passwod = "";
    private String host = "";
    private Integer port = 0;
    private String dbName = "";
    private Statement statement = null;

    public MyDB(String Host, int PORT, String dbNAME) {
        host = Host;
        port = PORT;
        dbName = dbNAME;
    }

    public void setUser(String USER) {
        user = USER;
    }

    public void setPasswod(String PASSWORD) {
        passwod = PASSWORD;
    }

    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);//"root"
        connectionProps.put("password", passwod);//"SekN3!1928"
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try {
            conn = DriverManager.getConnection(jdbcString, connectionProps);
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Błąd połączenia do bazy: " + jdbcString);
            System.out.println("Komunikat błędu: " + e.getMessage());
            conn = null;
        }
        System.out.println("Connected to database: " + dbName);
    }

    public Connection getConnection() {
        if (conn == null)
            connect();
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Błąd przy zamykaniu połączenia bazodanowego: " + e.getMessage());
            }
        }
    }
}
