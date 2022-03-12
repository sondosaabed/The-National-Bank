package SQL;

import java.sql.*;
import java.util.Properties;

/* 
    This class is used to make a connection to database
*/

public class DataBaseConnection {

    private String dbURL;
    private String dbUsername = "root";
    private String dbPassword = "0000";
    private String URL = "127.0.0.1";
    private String port = "3306";
    private String dbName = "bank";
    private Connection con;

    private void connectDB() throws ClassNotFoundException, SQLException {
        dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user", dbUsername);
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(dbURL, p);
    }

    public void connect() throws SQLException, ClassNotFoundException {
        connectDB();
    }

    public Connection getCon() {
        return con;
    }

    public boolean ExecuteStatement(String SQL) throws SQLException {
        try {
            connect();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();
            con.close();
            return true;
        } catch (SQLException | ClassNotFoundException s) {
            s.printStackTrace();
            System.out.println("SQL statement is not executed!");
            return false;
        }
    }
}
