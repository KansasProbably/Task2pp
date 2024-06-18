package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL ="jdbc:mysql://localhost:3306/task1";
    private static final String DB_ROOT ="root";
    private static final String DB_PASSWORD ="root";


    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL,DB_ROOT,DB_PASSWORD);
            System.out.println("Connection established");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection not established");
        }

        return conn;
    }
}
