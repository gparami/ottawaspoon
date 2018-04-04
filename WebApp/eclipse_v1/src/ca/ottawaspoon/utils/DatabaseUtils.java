package ca.ottawaspoon.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.tools.DocumentationTool.Location;

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
	
	/**
	 * Creates a Rater record in the database.
	 * @param conn connection to the database
	 * @param newRater newRater object with new information
	 * @return a success signal
	 * @throws SQLException SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a false
	 */
	public static boolean addRater(Connection conn, Rater newRater) throws SQLException {
		
		boolean success = false;
		String sql = "insert into ottawaspoon.rater (userId,e_mail,name,type,join_date,reputation,password) values ('?','?','?','?','?',?,'?'),";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, newRater.getUserName());
        pstm.setString(2, newRater.getEmail());
        pstm.setString(3, newRater.getName());
        pstm.setString(4, newRater.getType());
        pstm.setDate(5, newRater.getJoin_date());
        pstm.setInt(6, newRater.getReputation());
        pstm.setString(7, newRater.getPassword());
        
        try {
	    	 	pstm.executeQuery();
	    	 	success = true;
		} catch (SQLException e) {
				success = false;
    			System.out.println("Error Occured while executing DatabaseUtils.addRater()");
	    }
	    return success;
	}
	
	public static ArrayList<Restaurant> aquery(Connection conn, String restName) throws SQLException {
		 
        String sql = "select *\n" + 
        		"from restaurant natural join location\n" + 
        		"where restaurant.name = '?'";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restName);
        ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
        
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         while (rs.next()) {
	        	 Restaurant rest = new Restaurant();
	        	 rest.setRestaurantID(rs.getString("restaurantID"));
	        	 rest.setName(rs.getString("name"));
	        	 rest.setType(rs.getString("type"));
	        	 rest.setUrl(rs.getString("url"));
	        	 Location loc = new Location();
	        	 loc.setLocationID(rs.getString("locationID"));
	        	 loc.setOpen_date(rs.getString("open_date"));
	        	 loc.setManager(rs.getString("manager"));
	        	 loc.setPhone(rs.getString("phone"));
	        	 loc.setAddress(rs.getString("address"));
	        	 loc.setHours_open(rs.getString("hours_open"));
	        	 loc.setHours_close(rs.getString("hours_close"));
	        	 loc.setRestaurantID(rs.getString("restaurantID"))
	        	 ArrayList<Location> arrayLoc = new  ArrayList<Location>();
	        	 arrayLoc.add(loc);
	        	 rest.setLocations(arrayLoc);   	 
	        	 
	             rests.add(rest);
	         }
	         return rests;
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing querry a");
	    }
        return null;
    }
	
	public static ArrayList<MenuItem> bquery(Connection conn, String restName) throws SQLException {
		 
        String sql = "select  i.name, i.price\n" + 
        		"from menuitem i, restaurant r\n" + 
        		"where r.name = '?'\n" + 
        		"and r.restaurantID = i.restaurantID\n" + 
        		"order by category";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restName); 
        ArrayList<MenuItem> menus;
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         while (rs.next()) {
	        	 MenuItem item = new MenuItem();
	        	 item.setName(rs.getString("name"));
	        	 item.setCategory(rs.getString("category"));
	        	 item.setPrice(rs.getString("price"));   
	             menus.add(item);
	         }
	         return menus;
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing query b");
	    }
        return null;
    }
	public static ArrayList<Restaurant> cquery(Connection conn, String category) throws SQLException {
		 
        String sql = "select l.open_date, l.manager\n" + 
        		"from restaurant r natural join location l\n" + 
        		"where r.type = '?'";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, category); 
        ArrayList<Restaurant> rests;
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         while (rs.next()) {
	        	 Restaurant rest = new Restaurant();	        	
	        	 rest.setType(rs.getString("type"));	        	
	        	 Location loc = new Location();	        	 
	        	 loc.setOpen_date(rs.getString("open_date"));
	        	 loc.setManager(rs.getString("manager"));	        	
	        	 ArrayList<Location> arrayLoc = new  ArrayList<Location>();
	        	 arrayLoc.add(loc);
	        	 rest.setLocations(arrayLoc);   
	        	 rests.add(rest)
	         }
	         return rests;
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing query c");
	    }
        return null;
    }	
	public static ArrayList<Restaurant> dquery(Connection conn, String restName) throws SQLException {
		 
        String sql = "select r.name, i.name as menue_Item, l.manager, pr.price as most_expensive_price, l.address, l.hours_open\n" + 
        		"from restaurant r, menuitem i, location l, (select price, restaurantID,itemID\n" + 
        		"												from menuitem\n" + 
        		"												) as pr\n" + 
        		"where pr.price >= all(select price\n" + 
        		"					from menuitem\n" + 
        		"					where r.restaurantID = restaurantID)\n" +         		
        		"		and r.name = '?'\n" + 
        		"		and i.itemID = pr.itemID\n" + 
        		"		and l.restaurantID = r.restaurantID\n" + 
        		"		and pr.restaurantID = r.restaurantID\n" + 
        		"		and i.restaurantID = r.restaurantID";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restName);
        ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
        
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         while (rs.next()) {
	        	 Restaurant rest = new Restaurant();
	        	 rest.setName(rs.getString("name"));
	        	 rest.setUrl(rs.getString("url"));
	        	 Location loc = new Location();
	        	 
	        	 ArrayList<Location> arrayLoc = new  ArrayList<Location>();
	        	 loc.setManager(rs.getString("manager"));	        	 
	        	 loc.setAddress(rs.getString("address"));
	        	 loc.setHours_open(rs.getString("hours_open"));  
	        	 arrayLoc.add(loc);
	        	 rest.setLocations(arrayLoc);   
	        	 
	        	 ArrayList<MenuItem> menus= new ArrayList<MenuItem>();
	        	 MenuItem item = new MenuItem();
	        	 item.setName(rs.getString("menue_Item"));
	        	 item.setPrice(rs.getString("price"));   
	             menus.add(item);
	        	 rest.setMenuItems(menus)
	             
	             rests.add(rest);
	         }
	         return rests;
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing querry d");
	    }
        return null;
    }
	
	public static ArrayList<Restaurant> equery(Connection conn) throws SQLException {
		 
        String sql = "select r.type, i.category, avg(i.price) as average_price\n" + 
        		"from restaurant r, menuitem i\n" + 
        		"where r.restaurantID = i.restaurantID\n" + 
        		"group by r.type, i.category";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
        
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         while (rs.next()) {
	        	 Restaurant rest = new Restaurant();
	        	 rest.setType(rs.getString("type"));
	        	 
	        	 ArrayList<MenuItem> menus= new ArrayList<MenuItem>();
	        	 MenuItem item = new MenuItem();
	        	 item.setName(rs.getString("menue_Item"));
	        	 item.setPrice(rs.getString("average_price"));   
	             menus.add(item);
	        	 rest.setMenuItems(menus)
	             
	             rests.add(rest);
	         }
	         return rests;
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing querry e");
	    }
        return null;
    }
	//<3
	public static ArrayList<Restaurant> fquery(Connection conn, String restName) throws SQLException {
		 
        String sql = "select r.name, rat.name as rater, round(avg(rt.food + rt.mood + rt.staff + rt.price),2) as average_score,count(*) as total_amount_of_ratings\n" + 
        		"from restaurant r, rater rat, rating rt\n" + 
        		"where r.restaurantiD = rt.restaurantiD\n" + 
        		"	and rt.userID = rat.userID\n" + 
        		"group by r.name, rat.name\n" + 
        		"order by r.name";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restName);
        ArrayList<String> toReturn = new ArrayList<String>();
        
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         while (rs.next()) {
	        	 ArrayList<String> allInOneLine = 
	        			 new ArrayList<>(Arrays.asList(rs.getString("name"),
	        				rs.getString("rater"), rs.getString("average_score"),
	        				rs.getString("total_amount_of_ratings")));
	        	 toReturn.add(allInOneLine)
	         }
	         return toReturn;
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing querry f");
	    }
        return null;
    }
	
	public static ArrayList<Restaurant> gquery(Connection conn) throws SQLException {
		 
        String sql = "select name, type, phone\n" + 
        		"from restaurant r, location l, rating rt\n" + 
        		"where rt.restaurantiD = r.restaurantiD \n" + 
        		"and r.restaurantiD = l.restaurantiD\n" + 
        		"		and \n" + 
        		"		(select restaurantiD\n" + 
        		"		from restaurant\n" + 
        		"		where restaurantiD = r.restaurantiD) not in(select rr.restaurantiD\n" + 
        		"											from restaurant rr, rating rtt\n" + 
        		"											where rr.restaurantiD = r.restaurantiD\n" + 
        		"											and rtt.restaurantiD = rr.restaurantiD\n" + 
        		"											and rtt.date::text like '2015-1-__' )";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
        
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         while (rs.next()) {
	        	 Restaurant rest = new Restaurant();
	        	 rest.setName(rs.getString("name"));
	        	 rest.setType(rs.getString("type"));
	        	 Location loc = new Location();
	        	 
	        	 ArrayList<Location> arrayLoc = new  ArrayList<Location>();
	        	 loc.setPhone(rs.getString("phone"));   
	        	 arrayLoc.add(loc);
	        	 rest.setLocations(arrayLoc);   	 
	        	 
	             rests.add(rest);
	         }
	         return rests;
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing querry g");
	    }
        return null;
    }

}
