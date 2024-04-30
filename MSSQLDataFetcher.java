import java.sql.*;

public class MSSQLDataFetcher {

    public static void main(String[] args) {
        // JDBC URL for connecting to the SQL Server database with Windows Authentication
        String jdbcUrl = "jdbc:sqlserver://your_server_address:port;databaseName=your_database_name;integratedSecurity=true";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection to the database
            connection = DriverManager.getConnection(jdbcUrl);

            // Create a statement object
            statement = connection.createStatement();

            // Define SQL query
            String sqlQuery = "SELECT * FROM your_table_name";

            // Execute the query
            resultSet = statement.executeQuery(sqlQuery);

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // Retrieve other columns as needed
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
