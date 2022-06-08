package pl.lublin.wsei.java.cwiczenia.TestMyDB.java;
import pl.lublin.wsei.java.cwiczenia.MyDB.java.MyDB;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {
        MyDB db = new MyDB("localhost", 3306, "mydb");
        db.setUser("root");
        db.setPasswod("SekN3!1928");
        Connection conn = db.getConnection();
        if (conn != null){
            System.out.println("Połączenie z bazą danych nawiązane");
        }
    }
}
