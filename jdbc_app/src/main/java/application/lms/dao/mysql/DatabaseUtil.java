package application.lms.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://bassure.in:3306/dhinakaran_db";
    private static final String USERNAME = "dhinakaran";
    private static final String PASSWORD = "bassure@33";

    public DatabaseUtil() {
        try {
            Class.forName(DRIVER_PATH);
        } catch (ClassNotFoundException e) {
            throw new Error("someting went worng : " + e);
        }
    }//End of Constructor

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Connection failed");
        }
        return null;
    }//End of getConnection()
}
