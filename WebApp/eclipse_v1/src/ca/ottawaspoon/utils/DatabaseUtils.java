package ca.ottawaspoon.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

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
     * Returns the max restaurant id from restaurant ids.
     * @param conn connection to the database
     * @return a new integer with the highest restaurant id
     * @throws SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns -1
     */
    public static int getLastRestaurantID(Connection conn) throws SQLException {

        int id = 0;

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT max(r.restaurantid) FROM restaurant r");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            return id;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing DatabaseUtils.getLastRestaurantID()");
        }
        return -1;
    }

    /**
     * Creates an ArrayList of restaurant names.
     * @param conn connection to the database
     * @return a new <code>ArrayList</code> with restaurant names
     * @throws SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a null
     */
    public static ArrayList < String > getRestaurantNames(Connection conn) throws SQLException {

        ArrayList < String > restaurantNames = new ArrayList < String > ();

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
    
    public static ArrayList < Category > getCategories(Connection conn) throws SQLException {

        ArrayList < Category > categories = new ArrayList < Category > ();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT DISTINCT  r.type FROM restaurant r");
            
            while (rs.next()) {
            	Category category = new Category();
            	category.setName(rs.getString(1));
            	categories.add(category);
            }
            rs.close();
            return categories;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing DatabaseUtils.getCategories()");
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
        String sql = "INSERT INTO ottawaspoon.rater (userId,e_mail,name,type,join_date,reputation,password) VALUES(?,?,?,?,?,?,?)";
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
    
    public static boolean addMenuItem(Connection conn, MenuItem newMenuItem) throws SQLException {

        boolean success = false;

        String sql = "insert into ottawaspoon.MenuItem(itemID,name,type,category,description,price,restaurantID) values(?,?,?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, newMenuItem.getItemID());
        pstm.setString(2, newMenuItem.getName());
        pstm.setString(3, newMenuItem.getType());
        pstm.setString(4, newMenuItem.getCategory());
        pstm.setString(5, newMenuItem.getDescription());
        pstm.setInt(6, newMenuItem.getPrice());
        pstm.setInt(7, newMenuItem.getRestaurantID());

        try {
            pstm.executeQuery();
            success = true;
        } catch (SQLException e) {
            success = false;
            System.out.println("Error Occured while executing DatabaseUtils.addMenuItem()");
        }
        return success;
    }

    /**
     * Creates a Restaurant record in the database.
     * @param conn connection to the database
     * @param newRestaurant new Restaurant object with new information
     * @return a success signal
     * @throws SQLException SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a false
     */
    public static boolean addRestaurant(Connection conn, Restaurant newRestaurant) throws SQLException {

        boolean success = false;

        String sql = "INSERT INTO ottawaspoon.restaurant(restaurantID,name,type,url) VALUES(?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, newRestaurant.getRestaurantID());
        pstm.setString(2, newRestaurant.getName());
        pstm.setString(3, newRestaurant.getType());
        pstm.setString(4, newRestaurant.getUrl());

        try {
            pstm.executeQuery();
            success = true;
        } catch (SQLException e) {
            success = false;
            System.out.println("Error Occured while executing DatabaseUtils.addRestaurant()");
        }
        return success;
    }

    /**
     * Creates a Restaurant record in the database.
     * @param conn connection to the database
     * @param restaurantid an existing Restaurant ID
     * @return a success signal
     * @throws SQLException SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a false
     */
    public static boolean deleteRestaurant(Connection conn, int restaurantid) throws SQLException {

        boolean success = false;
        String sql = "delete from restaurant where restaurant.restaurantID = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, restaurantid);

        try {
            pstm.executeQuery();
            success = true;
        } catch (SQLException e) {
            success = false;
            System.out.println("Error Occured while executing DatabaseUtils.deleteRestaurant()");
        }
        return success;
    }
    
    public static boolean deleteMenuItem(Connection conn, int itemID) throws SQLException {

        boolean success = false;
        String sql = "delete from menuItem where menuItem.itemID = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, itemID);

        try {
            pstm.executeQuery();
            success = true;
        } catch (SQLException e) {
            success = false;
            System.out.println("Error Occured while executing DatabaseUtils.deleteMenuItem()");
        }
        return success;
    }
    
    public static boolean deleteRater(Connection conn, String raterID) throws SQLException {

        boolean success = false;
        String sql = "delete from rater where rater.userID = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, raterID);

        try {
            pstm.executeQuery();
            success = true;
        } catch (SQLException e) {
            success = false;
            System.out.println("Error Occured while executing DatabaseUtils.deleteRater()");
        }
        return success;
    }


    /**
     * Creates an ArrayList of restaurants.
     * @param conn connection to the database
     * @return a new <code>ArrayList</code> with restaurant names
     * @throws SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a null
     */
    public static ArrayList < Restaurant > getRestaurants(Connection conn) throws SQLException {

        ArrayList < Restaurant > restaurants = new ArrayList < Restaurant > ();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM restaurant");
            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantID(rs.getInt("restaurantID"));
                restaurant.setName(rs.getString("name"));
                restaurant.setType(rs.getString("type"));
                restaurant.setUrl(rs.getString("url"));
                restaurants.add(restaurant);
            }
            rs.close();
            return restaurants;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing DatabaseUtils.getRestaurants()");
        }
        return null;
    }
    
    /**
     * Query A) Display all the information about a user‐specified restaurant. That is, the user should select the
     * name of the restaurant from a list, and the information as contained in the restaurant and
     * location tables should then displayed on the screen.
     * 
     * @param conn connection to the database
     * @param restaurantName name of the restaurant
     * @return a <code>Restaurant</code> object with it's locations 
     * @throws SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a null
     */
    public static Restaurant getRestaurant(Connection conn, String restaurantName) throws SQLException {

        String sql = "SELECT *\n" +
            "FROM restaurant r LEFT JOIN location l ON r.restaurantid=l.restaurantid\n" +
            "WHERE r.name = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restaurantName);

        Restaurant restaurant = new Restaurant();
        ArrayList < Location > locations = new ArrayList < Location > ();
        restaurant.setName(restaurantName);

        try {
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

            	restaurant.setRestaurantID(rs.getInt("restaurantid"));
                restaurant.setName(rs.getString("name"));
                restaurant.setType(rs.getString("type"));
                restaurant.setUrl(rs.getString("url"));

                locations.add(new Location(rs.getInt("locationid"),
                    rs.getDate("open_date"),
                    rs.getString("manager"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getInt("hours_open"),
                    rs.getInt("hours_close"),
                    rs.getInt("restaurantid")));
            }

            restaurant.setLocations(locations);
            return restaurant;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing DatabaseUtils.getRestaurant()");
        }
        return null;
    }

    /**
     * Query A) Display all the information about a user‐specified restaurant. That is, the user should select the
     * name of the restaurant from a list, and the information as contained in the restaurant and
     * location tables should then displayed on the screen.
     * 
     * @param conn conn connection to the database
     * @param restaurantid id of the restaurant
     * @return a <code>Restaurant</code> object with it's locations 
     * @throws SQLException if a database access error occurs or this method is called on a closed connection; if thrown returns a null
     */
    public static Restaurant getRestaurant(Connection conn, int restaurantid) throws SQLException {

        String sql = "SELECT *\n" +
            "FROM restaurant r LEFT JOIN location l ON r.restaurantid=l.restaurantid\n" +
            "WHERE r.restaurantid = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, restaurantid);

        Restaurant restaurant = new Restaurant();
        ArrayList < Location > locations = new ArrayList < Location > ();

        try {
            ResultSet rs = pstm.executeQuery();
            restaurant.setRestaurantID(restaurantid);

            while (rs.next()) {

                restaurant.setName(rs.getString("name"));
                restaurant.setType(rs.getString("type"));
                restaurant.setUrl(rs.getString("url"));

                locations.add(new Location(rs.getInt("locationid"),
                    rs.getDate("open_date"),
                    rs.getString("manager"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getInt("hours_open"),
                    rs.getInt("hours_close"),
                    rs.getInt("restaurantid")));
            }

            restaurant.setLocations(locations);
            return restaurant;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing DatabaseUtils.getRestaurant()");
        }
        return null;
    }


    public static ArrayList < MenuItem > bquery(Connection conn, String restName) throws SQLException {

        String sql = "select  i.category, i.name, i.price\n" +
            "from menuitem i, restaurant r\n" +
            "where r.name = ?\n" +
            "and r.restaurantID = i.restaurantID\n" +
            "order by category";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restName);
        ArrayList < ca.ottawaspoon.beans.MenuItem > menus = new ArrayList < ca.ottawaspoon.beans.MenuItem > ();
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ca.ottawaspoon.beans.MenuItem item = new ca.ottawaspoon.beans.MenuItem();
                item.setName(rs.getString("name"));
                item.setCategory(rs.getString("category"));
                item.setPrice(Integer.valueOf(rs.getString("price")));
                menus.add(item);
            }
            return menus;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing query b");
        }
        return null;
    }
    public static ArrayList < CBean > cquery(Connection conn, String category) throws SQLException {

        String sql = "SELECT l.open_date, l.manager\n" + 
        		"FROM restaurant r NATURAL JOIN location l\n" + 
        		"WHERE r.type = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, category);
        ArrayList < CBean > cats = new ArrayList < CBean > ();
        
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
            	cats.add(new CBean(rs.getDate(1),rs.getString(2)));
            }
            return cats;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing query c");
        }
        return null;
    }
    public static MostExpensiveMenuItem dquery(Connection conn, String restName) throws SQLException {

        String sql = "select r.name, i.name as menue_Item, l.manager, pr.price as most_expensive_price, r.url, l.hours_open\n" +
            "from restaurant r, menuitem i, location l, (select price, restaurantID,itemID\n" +
            "												from menuitem\n" +
            "												) as pr\n" +
            "where pr.price >= all(select price\n" +
            "					from menuitem\n" +
            "					where r.restaurantID = restaurantID)\n" +
            "		and r.name = ?\n" +
            "		and i.itemID = pr.itemID\n" +
            "		and l.restaurantID = r.restaurantID\n" +
            "		and pr.restaurantID = r.restaurantID\n" +
            "		and i.restaurantID = r.restaurantID";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restName);

        try {
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new MostExpensiveMenuItem(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println("Error Occured while executing querry d");
        }
        return null;
    }

    public static ArrayList < EBean > equery(Connection conn) throws SQLException {

        String sql = "select r.type, i.category, avg(i.price) as average_price\n" +
            "from restaurant r, menuitem i\n" +
            "where r.restaurantID = i.restaurantID\n" +
            "group by r.type, i.category";

        PreparedStatement pstm = conn.prepareStatement(sql);
        ArrayList < EBean > result = new ArrayList < EBean > ();

        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
            	result.add(new EBean(rs.getString(1),rs.getString(2),rs.getDouble(3)));
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing querry e");
        }
        return null;
    }
    
    
    //<3
    public static ArrayList <Ratings> fquery(Connection conn) throws SQLException {

        String sql = "select r.name, rat.name as rater, round(avg(rt.food + rt.mood + rt.staff + rt.price),2) as average_score,count(*) as total_amount_of_ratings\n" +
            "from restaurant r, rater rat, rating rt\n" +
            "where r.restaurantiD = rt.restaurantiD\n" +
            "	and rt.userID = rat.userID\n" +
            "group by r.name, rat.name\n" +
            "order by r.name";

        PreparedStatement pstm = conn.prepareStatement(sql);
        ArrayList < Ratings > toReturn = new ArrayList < Ratings > ();

        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                toReturn.add(new Ratings(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
            }
            return toReturn;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing querry f");
        }
        return null;
    }

    public static ArrayList < GBean > gquery(Connection conn) throws SQLException {

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
        ArrayList < GBean > results = new ArrayList < GBean > ();

        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                results.add(new GBean(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            return results;
        } catch (SQLException e) {
            System.out.println("Error Occured while executing querry g");
        }
        return null;
    }


    //aleks
    public static ArrayList < ArrayList < String >> o(Connection conn) {
        String sql = " select deviations.userid ,deviations.dev ,rat.name as ratname ,rat.type ,rat.e_mail ,rating.food ,r.name\n" +
            "from (select stddev(food) dev, rater.userid userid\n" +
            "from rating natural join rater\n" +
            "group by rater.userid) as deviations,\n" +

            "(select max(internDev.dev) devMax\n" +
            "from\n" +
            "(select stddev(food) dev, rater.userid userid\n" +
            "from rating natural join rater\n" +
            "group by rater.userid) as internDev)\n" +
            "as deviationsMax,\n" +
            "rater rat,\n" +
            "rating,\n" +
            "restaurant r\n" +
            "where deviations.dev = deviationsMax.devMax and rat.userid= deviations.userid and rating.userid = rat.userid and r.restaurantid = rating.restaurantid\n";

        ArrayList < ArrayList < String >> returnOfO = new ArrayList < ArrayList < String >> ();

        try {
            ResultSet rs = conn.prepareStatement(sql).executeQuery(sql);
            while (rs.next()) {
                ArrayList < String > temp = new ArrayList < String > ();
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
        } catch (SQLException e) {
            System.out.println("Aleks error JAVAUtils o) ha-ha");
        }
        return null;
    }

    public static ArrayList < Rater > n(Connection conn) {
        String sql = "select rat.name, rat.e_mail\n" +
            "from rater rat,	\n" +
            "(select (avg(price) + avg(food) + avg(mood) + avg(staff)) as tottalRating, rater.userid as thisguy\n" +
            "from rater, rating\n" +
            "where rater.userid = rating.userid\n" +
            "group by rater.userid\n" +
            ") as userinfo,\n" +

            "(select (avg(price) + avg(food) + avg(mood) + avg(staff)) as tottalRating\n" +
            "from rater jrat, rating jrt\n" +
            "where jrat.userid = jrt.userid\n" +
            "and jrat.name = 'John') as john\n" +

            "where rat.userid = userinfo.thisguy\n" +
            "and userinfo.tottalRating < john.tottalRating\n";


        ArrayList < Rater > outN = new ArrayList < Rater > ();
        try {
            //PrepareStatement pstm = ;
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                Rater temp = new Rater();
                temp.setName(rs.getString("name"));
                temp.setEmail(rs.getString("email"));
                outN.add(temp);
            }
            return outN;
        } catch (SQLException e) {
            System.out.println("Aleks error JAVAUtils n) ha-ha");
        }
        return null;
    }
    public static ArrayList < ArrayList < String >> m(Connection conn, String restaurant) {
        String sql = "select rat.name, rat.reputation, rt.comment, mi.name, mi.price\n" +
            "from rater rat, restaurant r, rating rt, \n" +
            "menuitem mi, ratingitem ri, (select count(*) as tottal, rat.userid as rater\n" +
            "from rating rt, rater rat, restaurant r\n" +
            "where rt.userid = rat.userid\n" +
            "and r.restaurantid = rt.restaurantid\n" +
            "-- z is place holder\n" +
            "and r.name = ?\n" +
            "group by rat.userid\n" +
            ") as ratings,\n" +
            "(select max (ratings.tottal) as max_tottal\n" +
            "from  (select count(*) as tottal, rat.userid\n" +
            "from rating rt, rater rat, restaurant r\n" +
            "where rt.userid = rat.userid\n" +
            "and r.restaurantid = rt.restaurantid\n" +
            "-- z is place holder\n" +
            "and r.name = ?\n" +
            "group by rat.userid\n" +
            ") as ratings\n" +
            ") as max_ratings\n" +
            "where ratings.rater = rat.userid\n" +
            "	and ratings.tottal = max_ratings.max_tottal\n" +
            "	and rt.restaurantid = r.restaurantid\n" +
            "and rt.userid = rat.userid\n" +
            "-- z is place holder\n" +
            "and r.name = ?\n" +
            "and mi.restaurantid = r.restaurantid\n" +
            "and mi.itemid = ri.itemid\n";


        ArrayList < ArrayList < String >> outM = new ArrayList < ArrayList < String >> ();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, restaurant);
            pstm.setString(2, restaurant);
            pstm.setString(3, restaurant);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ArrayList < String > temp = new ArrayList < String > ();
                temp.add(rs.getString("rater"));
                temp.add(rs.getString("reputation"));
                temp.add(rs.getString("comment"));
                temp.add(rs.getString("name"));
                temp.add(rs.getString("price"));
                outM.add(temp);
            }
            return outM;
        } catch (SQLException e) {
            System.out.println("Aleks m) ha-ha");
        }
        return null;
    }

    public static ArrayList < ArrayList < String >> l(Connection conn) {
        String sql = "select rat.name as rater, rat.reputation, food + mood as rating, \n" +
            "r.name, rt.date\n" +
            "from rater rat, rating rt, restaurant r\n" +
            "where rat.userid = rt.userid\n" +
            "and rt.restaurantID = r.restaurantID\n" +
            "order by rating desc\n" +
            "limit 10\n";
        ArrayList < ArrayList < String >> outL = new ArrayList < ArrayList < String >> ();
        try {
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                ArrayList < String > temp = new ArrayList < String > ();
                temp.add(rs.getString("rater"));
                temp.add(rs.getString("reputation"));
                temp.add(rs.getString("rating"));
                temp.add(rs.getString("name"));
                temp.add(rs.getString("date"));
                outL.add(temp);
            }
            return outL;
        } catch (SQLException e) {
            System.out.println("Aleks l) ho-ho-ho");
        }
        return null;
    }
    public static ArrayList < ArrayList < String >> k(Connection conn) {
        String sql = "select rat.name as rater, rat.join_date, rat.reputation, food + mood as rating," +
            "r.name, rt.date" +
            "from rater rat, rating rt, restaurant r" +
            "where rat.userid = rt.userid" +
            "and rt.restaurantID = r.restaurantID" +
            "order by rating desc" +
            "limit 10";
        ArrayList < ArrayList < String >> outK = new ArrayList < ArrayList < String >> ();
        try {
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                ArrayList < String > temp = new ArrayList < String > ();
                temp.add(rs.getString("rater"));
                temp.add(rs.getString("join_date"));
                temp.add(rs.getString("reputation"));
                temp.add(rs.getString("rating"));
                temp.add(rs.getString("name"));
                temp.add(rs.getString("date"));

                outK.add(temp);
            }
            return outK;
        } catch (SQLException e) {
            System.out.println("Aleks k) ooo");
        }
        return null;
    }

    public static ArrayList < ArrayList < String >> j(Connection conn) {
        String sql = "select r.type, round(avg(rrt.price + rrt.food + rrt.mood + rrt.staff), 2) as ave_rating" +
            "from restaurant r, rating rrt" +
            "where r.restaurantID = rrt.restaurantID" +
            "and (select count(*)" +
            "from rating" +
            "where r.restaurantID = rrt.restaurantID" +
            ") > 0" +
            "group by r.type" +
            "order by ave_rating desc" +
            "limit 3";

        ArrayList < ArrayList < String >> outJ = new ArrayList < ArrayList < String >> ();
        try {
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                ArrayList < String > temp = new ArrayList < String > ();
                temp.add(rs.getString("type"));
                temp.add(rs.getString("ave_rating"));
                outJ.add(temp);
            }
            return outJ;
        } catch (SQLException e) {
            System.out.println("Aleks k) why did you go wrong");
        }
        return null;
    }

    public static ArrayList < IBean > iQuery(Connection conn, String restaurant) throws SQLException {
        String sql = "select r.name,rater.name\n" +
            "from rating rat natural join restaurant r,rater\n" +
            "where food =5 and rater.userid = rat.userid and r.type = ?";

        ArrayList < IBean > outI = new ArrayList < IBean> ();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, restaurant);
        
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
            	outI.add(new IBean(rs.getString(1),rs.getString(2)));
            }
            return outI;
        } catch (SQLException e) {
            System.out.println("Aleks error JAVAUtils i) ha-ha");
        }
        return null;

    }

    public static ArrayList <HBean> HQuery(Connection conn, String id) {
        String sql = "SELECT r.name,l.open_date\n" + 
        		"FROM (location l NATURAL JOIN restaurant r)NATURAL JOIN rating rat\n" + 
        		"WHERE rat.staff < any( SELECT rat.staff\n" + 
        		"                        FROM restaurant r NATURAL JOIN rating rat\n" + 
        		"                        WHERE rat.userId = ? )\n" + 
        		"ORDER BY rat.date";

        ArrayList <HBean> result = new ArrayList <HBean> ();

        try {
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                result.add(new HBean(rs.getString(1),rs.getDate(2)));
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Aleks error JAVAUtils h) ha-ha");
        }
        return null;

    }
    
    public static ArrayList <JBean> jQuery(Connection conn) throws SQLException{
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

        ArrayList<JBean> outJ = new ArrayList<JBean>();
        try{
        	Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
            	
            	outJ.add(new JBean(rs.getString(1),rs.getDouble(2)));
            	
            }
            return outJ;
        }catch (SQLException e) {
            System.out.println("Aleks j) why did you go wrong");
    }
    return null;
    }
    
    public static ArrayList<KBean> kQueryNew(Connection conn) throws SQLException{
        String sql = "select rat.name as user_name, rat.join_date, rat.reputation, food + mood as rating,"+ 
					        "r.name as rest_name, rt.date"+
					"from rater rat, rating rt, restaurant r"+
					"where rat.userid = rt.userid"+
					"and rt.restaurantID = r.restaurantID"+
					"order by rating desc"+
					"limit 10";
        ArrayList<KBean> outK = new ArrayList<KBean>();
        try{
            ResultSet rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()){
                KBean temp = new KBean((rs.getString("user_name")),rs.getDate("join_date"),rs.getInt("reputation"),rs.getInt("rating"),rs.getString("rest_name"),rs.getDate("date"));
            //  temp.add(rs.getString("rater"));
            //  temp.add(rs.getString("join_date"));
            //  temp.add(rs.getString("reputation"));
            //  temp.add(rs.getString("rating"));
            //  temp.add(rs.getString("name"));
            //  temp.add(rs.getString("date"));
                outK.add(temp);
            }
            return outK;
        }catch (SQLException e) {
            System.out.println("Aleks k) ooo");
    }
    return null;
    }
    
    public static ArrayList < LBean > lQuery(Connection conn) throws SQLException{
	    String sql = "select rat.name as user_name, rat.reputation, food + mood as rating," +
	        "r.name as rest_name, rt.date" +
	        "from rater rat, rating rt, restaurant r" +
	        "where rat.userid = rt.userid" +
	        "and rt.restaurantID = r.restaurantID" +
	        "order by rating desc" +
	        "limit 10";
	    ArrayList < LBean > outL = new ArrayList < LBean > ();
	    try {
	        ResultSet rs = conn.prepareStatement(sql).executeQuery();
	        while (rs.next()) {
	            LBean temp = new LBean(rs.getString("user_name"), rs.getInt("reputation"), rs.getInt("rating"), rs.getString("rest_name"), rs.getDate("date"));
	            //temp.add(rs.getString("rater"));
	            //temp.add(rs.getString("reputation"));
	            //temp.add(rs.getString("rating"));
	            //temp.add(rs.getString("name"));
	            //temp.add(rs.getString("date"));
	            outL.add(temp);
	        }
	        return outL;
	    } catch (SQLException e) {
	        System.out.println("Aleks l) ho-ho-ho");
	    }
	    return null;
	}
    
    public static ArrayList < Rater > nQuery(Connection conn) {
	    String sql = "select rat.name, rat.e_mail\n" +
	        "from rater rat,	\n" +
	        "(select (avg(price) + avg(food) + avg(mood) + avg(staff)) as tottalRating, rater.userid as thisguy\n" +
	        "from rater, rating\n" +
	        "where rater.userid = rating.userid\n" +
	        "group by rater.userid\n" +
	        ") as userinfo,\n" +

	        "(select (avg(price) + avg(food) + avg(mood) + avg(staff)) as tottalRating\n" +
	        "from rater jrat, rating jrt\n" +
	        "where jrat.userid = jrt.userid\n" +
	        "and jrat.name = 'John') as john\n" +

	        "where rat.userid = userinfo.thisguy\n" +
	        "and userinfo.tottalRating < john.tottalRating\n";


	    ArrayList < Rater > outN = new ArrayList < Rater > ();
	    try {
	        //PrepareStatement pstm = ;
	        ResultSet rs = conn.prepareStatement(sql).executeQuery();
	        while (rs.next()) {
	            Rater temp = new Rater();
	            temp.setName(rs.getString("name"));
	            temp.setEmail(rs.getString("email"));
	            outN.add(temp);
	        }
	        return outN;
	    } catch (SQLException e) {
	        System.out.println("Aleks error JAVAUtils n) ha-ha");
	    }
	    return null;
	}

}