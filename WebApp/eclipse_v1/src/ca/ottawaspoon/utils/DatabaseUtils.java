package ca.ottawaspoon.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ca.ottawaspoon.beans.*;

/**
 * This class uses SQL queries and return java elements.
 * @author Parami
 *
 */
public class DatabaseUtils {
	
	/**
	 * Finds a Rater by username and password.
	 * @param conn connection to the database
	 * @param userName user entered Username
	 * @param password user entered password
	 * @return a new <code>Rater</code> object with user if exists, otherwise null
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a null
	 */
	public static Rater findUser(Connection conn, String userName, String password) throws SQLException {
 
        String sql = "Select * from rater r where r.userID = ? and r.password= ?";
 
        //Artem checkout PreparedStatement docs. The "?" is the placeholder. #cool
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        
        try {
        	 	ResultSet rs = pstm.executeQuery();
             if (rs.next()) {
             		Rater user = new Rater();
             		user.setUserName(userName);
             		user.setPassword(password);
             		user.setEmail(rs.getString("e_mail"));
             		user.setName(rs.getString("name"));
             		user.setJoin_date(rs.getDate("join_date"));
             		user.setType(rs.getString("type"));
             		user.setReputation(rs.getShort("reputation"));
             		System.out.println("Finding User: " + userName + " via: DatabaseUtils.findUser(username, password)");
                 return user;
             }
        } catch (SQLException e) {
        		System.out.println("Error Occured while executing DatabaseUtils.findUser(username, password)");
        }
        return null;
    }
	
	/**
	 * Finds a Rater by username.
	 * @param conn connection to the database
	 * @param userName user entered Username
	 * @return a new <code>Rater</code> object with user if exists, otherwise null
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a null
	 */
	public static Rater findUser(Connection conn, String userName) throws SQLException {
		 
        String sql = "Select * from rater r where r.userID = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         if (rs.next()) {
	         		Rater user = new Rater();
	         		user.setUserName(userName);
	         		user.setPassword(rs.getString("password"));
	         		user.setEmail(rs.getString("e_mail"));
	         		user.setName(rs.getString("name"));
	         		user.setJoin_date(rs.getDate("join_date"));
	         		user.setType(rs.getString("type"));
	         		user.setReputation(rs.getShort("reputation"));
	         		System.out.println("Finding User: " + userName + " via: DatabaseUtils.findUser(username)");
	             return user;
	         }
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing DatabaseUtils.findUser(username)");
	    }
        return null;
    }
	
	/**
	 * Creates an ArrayList of restaurant names.
	 * @param conn connection to the database
	 * @return a new <code>ArrayList</code> with restaurant names
	 * @throws SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a null
	 */
	public static ArrayList<String> getRestaurantNames(Connection conn) throws SQLException {
		
		ArrayList<String> restaurantNames = new ArrayList<String>();
		
		try {
			Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT rs.name FROM restaurant rs");
            while (rs.next()) {
            		restaurantNames.add(rs.getString("name"));
            }
            rs.close();
            return restaurantNames;
		} catch (SQLException e) {
    			System.out.println("Error Occured while executing DatabaseUtils.getRestaurantNames()");
	    }
	    return null;
	}

}
