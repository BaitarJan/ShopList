package shopList.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class Database {
        private static final String URL = "jdbc:mysql://localhost:3306/shop_list?useSSL=false&serverTimezone=UTC";
        private static final String USER = "root";
        private static final String PASSWORD = "";


        // metoda pro získání připojení
        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Chyba při připojení k databázi", e);
            }
        }
    }



