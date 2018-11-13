package ca.ottawaspoon.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ca.ottawaspoon.beans.*;

/**
 * This class uses SQL queries and return java elements.
 * @author Parami
 *
 */
public class DatabaseUtils {

	// TODO need to add the rest of the queries to this class.
	
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
             		user.setUserID(userName);
             		user.setPassword(password);
             		user.setEmail(rs.getString("e_mail"));
             		user.setName(rs.getString("name"));
             		user.setJoin_date(rs.getDate("join_date"));
             		user.setType(rs.getString("type"));
             		user.setReputation(rs.getShort("reputation"));
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
	         		user.setUserID(userName);
	         		user.setPassword(rs.getString("password"));
	         		user.setEmail(rs.getString("e_mail"));
	         		user.setName(rs.getString("name"));
	         		user.setJoin_date(rs.getDate("join_date"));
	         		user.setType(rs.getString("type"));
	         		user.setReputation(rs.getShort("reputation"));
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
	
	
	
	
	//artem
	
	public static Restaurant a(Connection conn, String restName) throws SQLException {
		 
        String sql = "select dname, type, address, type, address, hours_open, hours_close\n" + 
        			"from restaurant r, location l\n" + 
        			"where r.name = ?\n" + 
        			"and r.restaurantID = l.restaurantID;";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restName);
 
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         if (rs.next()) {
	        	 Restaurant rest = new Restaurant();
	        	 rest.setName(rs.getString("name"));
	        	 rest.setType(rs.getString("type"));
	        	 
	             return user;
	         }
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing DatabaseUtils.findUser(username)");
	    }
        return null;
    }
	
	public static MenuItem b(Connection conn, String restName) throws SQLException {
		 
        String sql = "select  i.name, i.type, i.category, i.price\n" + 
        		"from menuitem i, restaurant r\n" + 
        		"where r.name = ?\n" + 
        		"and r.restaurantID = i.restaurantID\n" + 
        		"order by category";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restName);
 
        try {
	    	 	ResultSet rs = pstm.executeQuery();
	         if (rs.next()) {
	        	 MenuItem item = new MenuItem();
	        	 item.setName(rs.getString("name"));
	        	 item.setType(rs.getString("type"));
	        	 item.setCategory(rs.getString("category"));
	        	 item.setPrice(rs.getString("price"));   
	             return item;
	         }
	    } catch (SQLException e) {
	    		System.out.println("Error Occured while executing DatabaseUtils.findUser(username)");
	    }
        return null;
	}
	

	//aleks
	public static ArrayList<ArrayList<String>> o(Connection conn){
		String sql = " select deviations.userid ,deviations.dev ,rat.name as ratname ,rat.type ,rat.e_mail ,rating.food ,r.name\n"+
		"from (select stddev(food) dev, rater.userid userid\n"+
		"from rating natural join rater\n"+
		"group by rater.userid) as deviations,\n"+
			
		"(select max(internDev.dev) devMax\n"+
		"from\n"+
		"(select stddev(food) dev, rater.userid userid\n"+
		"from rating natural join rater\n"+
		"group by rater.userid) as internDev)\n"+
		"as deviationsMax,\n"+
		"rater rat,\n"+
		"rating,\n"+
		"restaurant r\n"+
		"where deviations.dev = deviationsMax.devMax and rat.userid= deviations.userid and rating.userid = rat.userid and r.restaurantid = rating.restaurantid\n";

		ArrayList<ArrayList<String>> returnOfO = new ArrayList<String>();

		try{
			ResultSet rs = conn.prepareStatement(sql).executeQuery(sql);
			while (rs.next()){
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(rs.getString("userid"));
				temp.add(rs.getString("dev"));
				temp.add(rs.getString("ratName"));
				temp.add(rs.getString("type"));
				temp.add(rs.getString("e_mail"));
				temp.add(rs.getString("food"));
				temp.add(rs.getString("name"));
				returnOfO.add(temp);
			}
			return returnOfO;
		}catch (SQLException e){
			System.out.println("Aleks error JAVAUtils o) ha-ha");
		}
		return null;
	}

	public static ArrayList<Rater> n(Connection conn){
		String sql = "select rat.name, rat.e_mail\n"+
					"from rater rat,	\n"+
					"(select (avg(price) + avg(food) + avg(mood) + avg(staff)) as tottalRating, rater.userid as thisguy\n"+
									"from rater, rating\n"+
									"where rater.userid = rating.userid\n"+
									"group by rater.userid\n"+
									") as userinfo,\n"+
									
									"(select (avg(price) + avg(food) + avg(mood) + avg(staff)) as tottalRating\n"+
									"from rater jrat, rating jrt\n"+
									"where jrat.userid = jrt.userid\n"+
									"and jrat.name = 'John') as john\n"+
						
		"where rat.userid = userinfo.thisguy\n"+
		"and userinfo.tottalRating < john.tottalRating\n";

		PrepareStatement pstm = conn.prepareStatement(sql);
		ArrayList<Rater> outN = new ArrayList<Rater>();
		try{
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				Rater  temp = new Rater();
				temp.setName(rs.getString("name"));
				temp.setEmail(rs.getString("email"));
				outN.add(temp);
			}	return outN;
		}catch (SQLException e){
			System.out.println("Aleks error JAVAUtils n) ha-ha");
		}
		return null;
	}
	public static ArrayList<ArrayList<string>> m(Connection conn,String restaurant){
		String sql = "select rat.name, rat.reputation, rt.comment, mi.name, mi.price\n"+
					 "from rater rat, restaurant r, rating rt, \n"+
										"menuitem mi, ratingitem ri, (select count(*) as tottal, rat.userid as rater\n"+
																	"from rating rt, rater rat, restaurant r\n"+
																	"where rt.userid = rat.userid\n"+
																	"and r.restaurantid = rt.restaurantid\n"+
																	"-- z is place holder\n"+
																	"and r.name = ?\n"+
																	"group by rat.userid\n"+																												
																	") as ratings,\n"+
																	"(select max (ratings.tottal) as max_tottal\n"+
																	"from  (select count(*) as tottal, rat.userid\n"+
																												"from rating rt, rater rat, restaurant r\n"+
																												"where rt.userid = rat.userid\n"+
																												"and r.restaurantid = rt.restaurantid\n"+
																												"-- z is place holder\n"+
																												"and r.name = ?\n"+
																												"group by rat.userid\n"+																											
																												") as ratings\n"+																																							
																												") as max_ratings\n"+
																												"where ratings.rater = rat.userid\n"+
																												"	and ratings.tottal = max_ratings.max_tottal\n"+
																												"	and rt.restaurantid = r.restaurantid\n"+
																												"and rt.userid = rat.userid\n"+
																												"-- z is place holder\n"+
																												"and r.name = ?\n"+
																												"and mi.restaurantid = r.restaurantid\n"+
																												"and mi.itemid = ri.itemid\n";
	
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, restaurant);
		pstm.setString(2, restaurant);
		pstm.setString(3, restaurant);
		ArrayList<ArrayList<String>> outM = new ArrayList<ArrayList<String>>();
		try{
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(rs.getString("rater"));
				temp.add(rs.getString("reputation"));
				temp.add(rs.getString("comment"));
				temp.add(rs.getString("name"));
				temp.add(rs.getString("price"));
				outM.add(temp);
			}
			return outM;
		}catch (SQLException e) {
			System.out.println("Aleks m) ha-ha");
	}
	return null;
	}

	public static ArrayList<ArrayList<String>> l (Connection conn){
		String sql =  "select rat.name as rater, rat.reputation, food + mood as rating, \n"+
		"r.name, rt.date\n"+
		"from rater rat, rating rt, restaurant r\n"+
		"where rat.userid = rt.userid\n"+
		"and rt.restaurantID = r.restaurantID\n"+
		"order by rating desc\n"+
		"limit 10\n";
		ArrayList<ArrayList<String>> outL = new ArrayList<ArrayList<String>>();
		try{
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while (rs.next()){
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(rs.getString("rater"));
				temp.add(rs.getString("reputation"));
				temp.add(rs.getString("rating"));
				temp.add(rs.getString("name"));
				temp.add(rs.getString("date"));
				outL.add(temp);
			}
			return outL;
		}catch (SQLException e){
			System.out.println("Aleks l) ho-ho-ho");
		}
		return null;
	}
	public static ArrayList<ArrayList<String>> k(Connection conn){
		String sql = "select rat.name as rater, rat.join_date, rat.reputation, food + mood as rating,"+ 
		"r.name, rt.date"+
		"from rater rat, rating rt, restaurant r"+
		"where rat.userid = rt.userid"+
		"and rt.restaurantID = r.restaurantID"+
		"order by rating desc"+
		"limit 10";
		ArrayList<ArrayList<String>> outK = new ArrayList<ArrayList<String>>();
		try{
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while (rs.next()){
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(rs.getString("rater"));
				temp.add(rs.getString("join_date"));
				temp.add(rs.getString("reputation"));
				temp.add(rs.getString("rating"));
				temp.add(rs.getString("name"));
				temp.add(rs.getString("date"));

				outK.add(temp);
			}
			return outK;
		}catch (SQLException e) {
			System.out.println("Aleks k) ooo");
	}
	return null;
	}

	public static ArrayList<ArrayList> j (Connection conn){
		String sql = "select r.type, round(avg(rrt.price + rrt.food + rrt.mood + rrt.staff), 2) as ave_rating"+
		"from restaurant r, rating rrt"+
		"where r.restaurantID = rrt.restaurantID"+
		"and (select count(*)"+
		"from rating"+
		"where r.restaurantID = rrt.restaurantID"+
		") > 0"+
		"group by r.type"+
		"order by ave_rating desc"+
		"limit 3";

		ArrayList<ArrayList<String>> outJ = new ArrayList<ArrayList<Sting>>();
		try{
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while (rs.next()){
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(rs.getString("type"));
				temp.add(rs.getString("ave_rating"));
				outJ.add(temp);
			}
			return outJ;
		}catch (SQLException e) {
			System.out.println("Aleks k) why did you go wrong");
	}
	return null;
	}

	public static ArrayList<ArrayList<String>> i(Connection conn,String restaurant){
		String sql = "select r.name,rater.name\n"+
		"from rating rat natural join restaurant r,rater\n"+ 
		"where food =5 and rater.userid = rat.userid and r.type =?--chineese placeholder\n";

		ArrayList<ArryaList<String>> outI =new ArrayList<ArryaList<String>>();
	
		try{
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while (rs.next()){
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(rs.getString("restaurant"));
				temp.add(rs.getString("name"));
				outI.add(temp);
			}
			return outI;
		}catch (SQLException e){
			System.out.println("Aleks error JAVAUtils o) ha-ha");
		}
		return null;
	
	}

	public static ArrayList<ArrayList<String>> h (Connection conn,String id){
		String sql = "select r.name,l.open_date"+
		"from (location l natural join restaurant r)natural join rating rat "+
		"where"+
			"rat.staff< any( select rat.staff"+
							"from restaurant r natural join rating rat"+
							"--place holder"+
							"where rat.userId =? )--placeholder"+
		"order by rat.date";

		ArrayList<ArrayList<String>> returnOfH = new ArrayList<String>();

		try{
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while(rs.next()){
				ArrayList<String> temp = new ArrayList<String>(); 
				temp.add(rs.getString("name"));
				temp.add(rs.getString("open_date"));
				returnOfH.add(temp);
			}
			return returnOfH;
		}catch (SQLException e){
			System.out.println("Aleks error JAVAUtils h) ha-ha");
		}
		return null;

	}
}
