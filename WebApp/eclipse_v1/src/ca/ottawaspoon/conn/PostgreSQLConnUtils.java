package ca.ottawaspoon.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnUtils {
	
	/**
	 * Connect to the PostgreSQL database.
	 * @return a Connection object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getPostgreSQLConnection() throws ClassNotFoundException, SQLException {
		
		final String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=ottawaspoon";
	    final String user = "postgres";
	    final String password = "postgres";
	    
	    Connection conn = null;
        try {
        	Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
        		System.out.println("org.postgresql.Driver not Found!");
            System.out.println(e.getMessage());
        }
        return conn;
	}

}
