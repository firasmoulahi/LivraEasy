package DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public record DataBase() {
    private static boolean isDriverLoaded = false;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            isDriverLoaded = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private final static String user = "SYSTEM";
    private final static String password = "azerty1234";

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        if (isDriverLoaded) {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established");
        }
        return con;
    }

    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.close();
            System.out.println("Connection closed");
        }
    }

    public static void dbExecuteQuery(String query) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // Execute the query
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error occurred during query execution: " + e.getMessage());
            throw e;
        }
    }

    public static ResultSet dbExecute(String query) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Execute the query and return the ResultSet
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error occurred during query execution: " + e.getMessage());
            throw e;
        }
    }
}
