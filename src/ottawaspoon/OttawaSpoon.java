package ottawaspoon;

import java.sql.*;
import java.util.Vector;

public class OttawaSpoon {

	public static void main(String[] args) {
		System.out.println("You suck!!! Thank you.Lets go!!!");
		try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgres://tpjdrpaw:ojYNNlKphTrospph3Evc9gS4OMv9N9RZ@stampy.db.elephantsql.com:5432/tpjdrpaw";
            String userid = "tpjdrpaw";
            String password = "ojYNNlKphTrospph3Evc9gS4OMv9N9RZ";
            Connection db = DriverManager.getConnection(url, userid, password);
            Statement st = db.createStatement();
            st.close();
        } catch (Exception e){System.out.println("Error - erorr@!!!!2211!@!@!@!!"); System.out.println(e);}
		
    }

    // void fillTheData(){
    //     String[] ratersNames = {"Parami","Steve","Artem","Aleks","Josh","Alen","Josh","Just Batman","Steven","HisName","Robin","Barbara","Baraque","Vladimir","Donald"};
    //     String ratersNamesString = "insert into ottawaspoon.rater (userId,name,type,join_date,reputation) values";
    //     String[] ratersEMail = {"hi@what.see","oh@simpson.homer","fun@fun.fun"};
        
    //     String[] restaurantNames = {"King for the people","Chopped head","Mug you","Not welcome","Dead on the inside","You Fool!","Come come","I know what you did last summer"};
    //     String restaurantsString ="insert into ottawaspoon.restaurant(restaurantID,name,type,url) values";
        
    //     String[] restaurantType = {"russian","indian","italian","chineese","thai","ucranian","georgian","candian"};
        
    //     //location stuff
    //     String[] managerNames = {"Parami","Steve","Artem","Aleks","Josh","Alen","Josh","Just Batman","Steven","HisName","Robin","Barbara","Baraque","Vladimir","Donald"};
        
    // }

   public class Rater{
       int userID;
       String eMail;
       String name;
       Date join_date;
       int type;
       int reputation;
   }
   public class Rating{
       int userId;
       Date date;
       int price;
       int food;
       int mood;
       int staff;
       String comment;
       int restaurantID;
   }
   public class Restaurant{
       int restaurantID;
       String name;
       String type;
       String url;

   }
   public class Location{
       int locationID;
       Date open_date;
       String manager;
       String phone;
       String address;
       Date hours_open;
       Date hours_close;
       int restaurantID;

   }

   public class MenuItem{
       int itemID;
       String name;
       String type;
       String category;
       String description;
       int price;
       int restaurantID;

   }

   public class RatingItem{
       int userID;
       Date date;
       int itemID;
       int itemRating;
       String comment;
   }

}
