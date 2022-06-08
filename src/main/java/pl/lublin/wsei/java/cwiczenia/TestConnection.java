package pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String serverName = "localhost";
        String dataBase = "mydb";
        Number port = 3306;
        Connection con = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user","root");
        connectionProps.put("password","SekN3!1928");
        connectionProps.put("serverTimezone","Europe/Warsaw");

        con = DriverManager.getConnection(
          "jdbc:mysql://"+ serverName + ":" + port + "/" + dataBase, connectionProps );

        System.out.println("connected");
    }
}
