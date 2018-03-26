//package fill_the_data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class OttawaSpoon {

	public static void main(String[] args) {
		System.out.println("You suck!!! Thank you.Lets go!!!");
		// try {
        //     Class.forName("org.postgresql.Driver");
        //     String url = "jdbc:postgres://tpjdrpaw:ojYNNlKphTrospph3Evc9gS4OMv9N9RZ@stampy.db.elephantsql.com:5432/tpjdrpaw";
        //     String userid = "tpjdrpaw";
        //     String password = "ojYNNlKphTrospph3Evc9gS4OMv9N9RZ";
        //     Connection db = DriverManager.getConnection(url, userid, password);
        //     Statement st = db.createStatement();
        //     st.close();
        // } catch (Exception e){System.out.println("Error - erorr@!!!!2211!@!@!@!!"); System.out.println(e);}
         OttawaSpoon fill = new OttawaSpoon();
         fill.fillTheData();
    }

    void fillTheData(){

        String out = "";

        /*RATERS*/

        //not in the sql
        
        int numOfRaters = 15;
        ArrayList <Rater> raters = new ArrayList <Rater>();

        /**************** */
 
        //id to be generated should be a string
        String[] passwords ={"\'1111\'","\'aaaa\'","\'bbbb\'","\'cccc\'"};
        String[] ratersEMail = {"\'hi@what.see\'","\'oh@simpson.homer\'","\'fun@fun.fun\'","\'home@canada.home\'"};

        String[] ratersNames = {"\'Parami\'","\'Steve\'","\'Artem\'","\'Aleks\'","\'Josh\'","\'Alen\'","\'Josh\'","\'Just Batman\'","\'Steven\'","\'HisName\'","\'Robin\'","\'Barbara\'","\'Baraque\'","\'Vladimir\'","\'Donald\'"};
        
        //join date to be generated randomly;
        String[] raterType = {"\'blog\'","\'online\'","\'food critic\'"};
        //reputation random 1 to 5

        String ratersString = "insert into ottawaspoon.rater (userId,e_mail,name,type,join_date,reputation,password) values";

        /************************************************** */
        
        /*RATING */
        //not in SQL
        int numOfRatings = 120;
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        //

        //id to be generated
        //date to be generated
        //price rat to be generated
        //food rat to be generated
        //Mood rat to be generated
        //Staff rat to be generated
        String[] comments = {"\'I like it\'","\'It was bad\'","\'How can you not love this place\'","\'I was never so happy\'"};
        //restaurant id to be generated 

        String ratingString = ";insert into ottawaspoon.rating (userId,date,price,food,mood,staff,comment,restaurantID) values\n";

        /**************************************************** */
        /*RESTAURANT*/
        //not in SQL
        ArrayList <Restaurant> restaurants = new ArrayList<Restaurant>();
        //int numOfRestaurants = 12;
        
        //
        //id to be generated

        //the names define how many restaurants 
        String[] restaurantNames = {"\'King for the people\'","\'Chopped head\'","\'Mug you\'","\'Not welcome\'","\'Dead on the inside\'","\'You Fool!\'","\'Come come\'","\'I know what you did last summer\'","\'You eat we see\'","\'Hi how are you\'","\'Strange soup\'","\'Cooking on your head\'"};
      
        String[] restaurantType = {"\'russian\'","\'indian\'","\'italian\'","\'chineese\'","\'thai\'","\'ucranian\'","\'georgian\'","\'candian\'"};
       
        String[] url = {"\'www.hat.co\'","\'www.das.ca\'","\'www.form.com\'","\'www.ed.fred\'"};

        String restaurantString =";insert into ottawaspoon.restaurant(restaurantID,name,type,url) values";


        /************************************************* */
        //LOCATION
        //not in sql
        ArrayList <Location> locations = new ArrayList <Location>();
        int numOfLocations = restaurants.size();
        //
        //id to be generated
        //open date to be generated
        String[] managerNames = {"\'Parami\'","\'Steve\'","\'Artem\'","\'Aleks\'","\'Josh\'","\'Alen\'","\'Josh\'","\'Just Batman\'","\'Steven\'","\'HisName\'","\'Robin\'","\'Barbara\'","\'Baraque\'","\'Vladimir\'","\'Donald\'"};
      
        String[] phoneNumbers = {"\'613whattoDO\'","\'3431249817\'","\'24981730\'","\'342329387432222hi\'"};
      
        String[] addresses = {"\'33 Bronson\'","\'34 Johnson\'","\'12 Eldgin\'","\'12 Hopekin\'"};

        //houropen to be generated
        //hour close to be generated
        //restaurantID to be generated

        String locationString = ";insert into ottawaspoon.location(locationId,open_Date,manager,phone,address,hours_open,hours_close,restaurantID) values";
        /************************************ */
        //MENU ITEM
        //not in sql
        int numOfMenuItems = restaurantNames.length*3;
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        //
        //id to be generated
        String[] itemName = {"\'fish\'","\'meat\'","\'bear with beer\'","\'ice on ice\'","\'rice\'","\'pear\'"};
        String[] type = {"\'food\'","\'beverage\'"};
        String[] category = {"\'starter\'","\'main\'","\'desert\'"};
        String[] description = {"\'You can eat me\'","\'Try to eat me\'","\'Drink and you die\'","\'You are dead\'"};
        //price to be generated
        //restaurant id to be generated
       

        String menuItemString = ";insert into ottawaspoon.MenuItem(itemID,name,type,category,description,price,restaurantID) values \n";

        /********************************* */
        //RATING ITEM
        //not in SQL
        int numOfRankingItems = 10;
        ArrayList<RatingItem> ratingItems = new ArrayList<RatingItem>();
        //
        //userId to be generated
        //Date to be generated
        //itemId to be generated
        //rating to be generated
        String[] comment = {"\'Tried and died\'","\'Seen people die trying\'","\'Love it\'","\'Hope could eat again\'"};

        String ratingItemsString = ";insert into ottawaspoon.ratingItem(userId,date,itemID,itemRating,comment) values";
        /******************************** */


        //fill the data from this point

        //create the raters
        for (int i = 0 ;i<numOfRaters;++i){
            raters.add(new Rater(Integer.toString(i+1),//userID
                            ratersEMail[randInt(0, ratersEMail.length-1)],//Email
                            ratersNames[randInt(0, ratersNames.length-1)],//Email
                            randomDate(),//dateRegistered
                            raterType[randInt(0,raterType.length-1)],//type
                            randInt(1,5),//reputation
                            passwords[randInt(0, passwords.length-1)]
            ));
        }
        //add raters to string
        out+=ratersString+"\n";
        for (Rater temp:raters){
            if (temp!=raters.get(raters.size()-1)){
            out +="(\'"+temp.getUserID()+"\',"+temp.geteMail()+","+temp.getName()+","+temp.getType()+","+"\'"+temp.getJoin_date().toString()+"\'"+","+temp.getReputation()+","+temp.getPassword()+")"+",\n";
            }
            else{
            out +="(\'"+temp.getUserID()+"\',"+temp.geteMail()+","+temp.getName()+","+temp.getType()+","+"\'"+temp.getJoin_date().toString()+"\'"+","+temp.getReputation()+","+temp.getPassword()+")"+"\n";    
            }
        }
        //

            //create restaurants
            for(int i=0;i<restaurantNames.length;++i){
                restaurants.add(new Restaurant(i+1,//restID
                                restaurantNames[i],//name
                                restaurantType[randInt(0,restaurantType.length-1)],//type
                                url[randInt(0, url.length-1)]//url
                )
                );
        }
        
        out += restaurantString;
        //add restaurants to the string
        for (Restaurant temp:restaurants){
            if (temp!=restaurants.get(restaurants.size()-1)){
            out +="("+temp.getRestaurantID()+","+temp.getName()+","+temp.getType()+","+temp.getUrl()+")"+",\n";
            }
            else{
                out +="("+temp.getRestaurantID()+","+temp.getName()+","+temp.getType()+","+temp.getUrl()+")"+"\n";
            }
        }
      
        
        //create the ratings
        int j = 0;
        for (int i = 0 ;i<numOfRatings;++i){  
                if (i%10==0){
                    j++;  
                }
                ratings.add(new Rating(Integer.toString(j%raters.size()+1),
                        randomDate(),//date
                        randInt(1, 5),//price
                        randInt(1, 5),//food
                        randInt(1, 5),//mood
                        randInt(1, 5),//staff
                        comments[randInt(0,comments.length-1)],//comment
                        randInt(1,restaurants.size())//restId
                        )
                );
            }
            ratings.add(new Rating("3",//rater id
                        randomDate(),//date
                        randInt(1, 5),//price
                        randInt(1, 5),//food
                        randInt(1, 5),//mood
                        randInt(1, 5),//staff
                        comments[randInt(0,comments.length-1)],//comment
                        3//restId
                        )
            );
            ratings.add(new Rating("3",//rater id
                        randomDate(),//date
                        randInt(1, 5),//price
                        randInt(1, 5),//food
                        randInt(1, 5),//mood
                        randInt(1, 5),//staff
                        comments[randInt(0,comments.length-1)],//comment
                        3//restId
                        )
            );
            ratings.add(new Rating("3",//rater id
                        new Date(117,12,19),//date
                        randInt(1, 5),//price
                        randInt(1, 5),//food
                        randInt(1, 5),//mood
                        randInt(1, 5),//staff
                        comments[randInt(0,comments.length-1)],//comment
                        3//restId
                        )
            );
            ratings.add(new Rating("3",//rater id
                        new Date(116, 1, 19),//date
                        randInt(1, 5),//price
                        randInt(1, 5),//food
                        randInt(1, 5),//mood
                        randInt(1, 5),//staff
                        comments[randInt(0,comments.length-1)],//comment
                        3//restId
                        )
            );
            out +=ratingString;
 //add ratings to the string
 for (Rating temp:ratings){
    if (temp!=ratings.get(ratings.size()-1)){
    out +="("+temp.getUserId()+","+"\'"+temp.getDate().toString()+"\'"+","+temp.getPrice()+","+temp.getFood()+","+temp.getMood()+","+temp.getStaff()+","+temp.getComment()+","+temp.getRestaurantID()+")"+",\n";
    }
    else{
        out +="("+temp.getUserId()+","+"\'"+temp.getDate().toString()+"\'"+","+temp.getPrice()+","+temp.getFood()+","+temp.getMood()+","+temp.getStaff()+","+temp.getComment()+","+temp.getRestaurantID()+")"+"\n";
    }
}
       
        //create locations
        for (int i = 0;i<restaurantNames.length;++i){
            locations.add(new Location(
                i+1,//location id
                randomDate(),//open date
                managerNames[randInt(0, managerNames.length-1)],//manager name
                phoneNumbers[randInt(0, phoneNumbers.length-1)],//phoneNum
                addresses[randInt(0,addresses.length-1)],//address
                randInt(0, 12),//hour -open
                randInt(13,24),//hour close
                randInt(0,restaurantNames.length-1)+1//restaurant id
                )
            );
        }

        out+=locationString;
      

        //add locations to the string
        for (Location temp:locations){
            if (temp!=locations.get(locations.size()-1)){
            out +="("+temp.getLocationID()+","+"\'"+temp.getOpen_date().toString()+"\'"+","+temp.getManager()+","+temp.getPhone()+","+temp.getAddress()+","+temp.getHours_open()+","+temp.getHours_close()+","+temp.getRestaurantID()+")"+",\n";
            }
            else{
                out +="("+temp.getLocationID()+","+"\'"+temp.getOpen_date().toString()+"\'"+","+temp.getManager()+","+temp.getPhone()+","+temp.getAddress()+","+temp.getHours_open()+","+temp.getHours_close()+","+temp.getRestaurantID()+")"+"\n";
            }
        }
       
        
        //create menuItem
        for (int i = 0; i<numOfMenuItems;++i){
            menuItems.add(new MenuItem(
                        i+1,//itemID
                        itemName[randInt(0, itemName.length-1)],//item name
                        type[randInt(0, type.length-1)],//itemType
                        category[randInt(0, category.length-1)],//category
                        description[randInt(0, description.length-1)],
                        randInt(1,100),//price
                        randInt(0, restaurants.size()-1)+1//restaurant id 
                        )
            );
        }
        //System.out.println(menuItems.size());
        out+=menuItemString; 

        
        //add locations to the string
        for (MenuItem temp:menuItems){
            if (temp!=menuItems.get(menuItems.size()-1)){
            out +="("+temp.getItemID()+","+temp.getName()+","+temp.getType()+","+temp.getCategory()+","+temp.getDescription()+","+temp.getPrice()+","+temp.getRestaurantID()+")"+",\n";
            }
            else{
                out +="("+temp.getItemID()+","+temp.getName()+","+temp.getType()+","+temp.getCategory()+","+temp.getDescription()+","+temp.getPrice()+","+temp.getRestaurantID()+")"+"\n";
            }
        }



      //  create rating item  //date and user id has to be in the ratings
        for (int i=0;i<numOfRankingItems;++i){
                Rating rating = ratings.get(randInt(0, ratings.size()-1));
                ratingItems.add(new RatingItem(
                        rating.getUserId(),//userID
                        rating.getDate(),//date
                        randInt(1,menuItems.size()),//itemID
                        randInt(1, 5),//Itemrating
                        comment[randInt(0, comment.length-1)]//comment
                    )
                );

        }

        out+=ratingItemsString;
      
        //add ratingItem to the string to the string
        for (RatingItem temp:ratingItems){
            if (temp!=ratingItems.get(ratingItems.size()-1)){
            out +="("+temp.getUserID()+","+"\'"+temp.getDate().toString()+"\'"+","+temp.getItemID()+","+temp.getItemRating()+","+temp.getComment()+")"+",\n";
            }
            else{
                out +="("+temp.getUserID()+","+"\'"+temp.getDate().toString()+"\'"+","+temp.getItemID()+","+temp.getItemRating()+","+temp.getComment()+")"+"\n";
            }
        }
      
        System.out.println(out);



    }

    private static Date randomDate(){
        Random  rnd;
        Date    dt;
        long    ms;

        rnd = new Random();

        ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));

        dt = new Date(ms);

        return dt;
    }

    private static int randInt(int min, int max) {

        Random rand = new Random();
    
        int randomNum = rand.nextInt((max - min) + 1) + min;
    
        return randomNum;
    }


    //internal classes
    private class Location {

        private int locationID;
        private Date open_date;
        private String manager;
        private String phone;
        private String address;
        private int hours_open;
        private int hours_close;
        private int restaurantID;
    
        public Location(int locationID, Date open_date, String manager, String phone, String address, int hours_open, int hours_close, int restaurantID) {
            this.locationID = locationID;
            this.open_date = open_date;
            this.manager = manager;
            this.phone = phone;
            this.address = address;
            this.hours_open = hours_open;
            this.hours_close = hours_close;
            this.restaurantID = restaurantID;
        }
    
        public Location() {
        }
    
        public int getLocationID() {
            return locationID;
        }
    
        public void setLocationID(int locationID) {
            this.locationID = locationID;
        }
    
        public Date getOpen_date() {
            return open_date;
        }
    
        public void setOpen_date(Date open_date) {
            this.open_date = open_date;
        }
    
        public String getManager() {
            return manager;
        }
    
        public void setManager(String manager) {
            this.manager = manager;
        }
    
        public String getPhone() {
            return phone;
        }
    
        public void setPhone(String phone) {
            this.phone = phone;
        }
    
        public String getAddress() {
            return address;
        }
    
        public void setAddress(String address) {
            this.address = address;
        }
    
        public int getHours_open() {
            return hours_open;
        }
    
        public void setHours_open(int hours_open) {
            this.hours_open = hours_open;
        }
    
        public int getHours_close() {
            return hours_close;
        }
    
        public void setHours_close(int hours_close) {
            this.hours_close = hours_close;
        }
    
        public int getRestaurantID() {
            return restaurantID;
        }
    
        public void setRestaurantID(int restaurantID) {
            this.restaurantID = restaurantID;
        }
    }

    private class MenuItem {

        private int itemID;
        private String name;
        private String type;
        private String category;
        private String description;
        private int price;
        private int restaurantID;
    
        public MenuItem() {
        }
    
        public MenuItem(int itemID, String name, String type, String category, String description, int price, int restaurantID) {
            this.itemID = itemID;
            this.name = name;
            this.type = type;
            this.category = category;
            this.description = description;
            this.price = price;
            this.restaurantID = restaurantID;
        }
    
        public int getItemID() {
            return itemID;
        }
    
        public void setItemID(int itemID) {
            this.itemID = itemID;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getType() {
            return type;
        }
    
        public void setType(String type) {
            this.type = type;
        }
    
        public String getCategory() {
            return category;
        }
    
        public void setCategory(String category) {
            this.category = category;
        }
    
        public String getDescription() {
            return description;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    
        public int getPrice() {
            return price;
        }
    
        public void setPrice(int price) {
            this.price = price;
        }
    
        public int getRestaurantID() {
            return restaurantID;
        }
    
        public void setRestaurantID(int restaurantID) {
            this.restaurantID = restaurantID;
        }
    }
    
    private class Rater {

        private String userID;
        private String password; 
        private String eMail;
        private String name;
        private Date join_date;
        private String type;
        private int reputation;
       
    
        public Rater() {
        }
    
        public Rater(String userID, String eMail, String name, Date join_date, String type, int reputation,String password) {
            this.userID = userID;
            this.eMail = eMail;
            this.name = name;
            this.join_date = join_date;
            this.type = type;
            this.reputation = reputation;
            this.password = password;
        }
    
        public String getUserID() {
            return userID;
        }
    
        public void setUserID(String userID) {
            this.userID = userID;
        }
    
        public String geteMail() {
            return eMail;
        }
    
        public void seteMail(String eMail) {
            this.eMail = eMail;
        }
        public String getPassword(){
            return password;
        }
        void setPassword(String password){
            this.password=password;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public Date getJoin_date() {
            return join_date;
        }
    
        public void setJoin_date(Date join_date) {
            this.join_date = join_date;
        }
    
        public String getType() {
            return type;
        }
    
        public void setType(String type) {
            this.type = type;
        }
    
        public int getReputation() {
            return reputation;
        }
    
        public void setReputation(int reputation) {
            this.reputation = reputation;
        }
    }
    
    private class Rating {

        private String userId;
        private Date date;
        private int price;
        private int food;
        private int mood;
        private int staff;
        private String comment;
        private int restaurantID;
    
        public Rating(String userId, Date date, int price, int food, int mood, int staff, String comment, int restaurantID) {
            this.userId = userId;
            this.date = date;
            this.price = price;
            this.food = food;
            this.mood = mood;
            this.staff = staff;
            this.comment = comment;
            this.restaurantID = restaurantID;
        }
    
        public Rating() {
    
        }
    
        public String getUserId() {
            return userId;
        }
    
        public void setUserId(String userId) {
            this.userId = userId;
        }
    
        public Date getDate() {
            return date;
        }
    
        public void setDate(Date date) {
            this.date = date;
        }
    
        public int getPrice() {
            return price;
        }
    
        public void setPrice(int price) {
            this.price = price;
        }
    
        public int getFood() {
            return food;
        }
    
        public void setFood(int food) {
            this.food = food;
        }
    
        public int getMood() {
            return mood;
        }
    
        public void setMood(int mood) {
            this.mood = mood;
        }
    
        public int getStaff() {
            return staff;
        }
    
        public void setStaff(int staff) {
            this.staff = staff;
        }
    
        public String getComment() {
            return comment;
        }
    
        public void setComment(String comment) {
            this.comment = comment;
        }
    
        public int getRestaurantID() {
            return restaurantID;
        }
    
        public void setRestaurantID(int restaurantID) {
            this.restaurantID = restaurantID;
        }
    }
    
    private class RatingItem {

        private String userID;
        private Date date;
        private int itemID;
        private int itemRating;
        private String comment;
    
        public RatingItem(String userID, Date date, int itemID, int itemRating, String comment) {
            this.userID = userID;
            this.date = date;
            this.itemID = itemID;
            this.itemRating = itemRating;
            this.comment = comment;
        }
    
        public RatingItem() {
        }
    
        public String getUserID() {
            return userID;
        }
    
        public void setUserID(String userID) {
            this.userID = userID;
        }
    
        public Date getDate() {
            return date;
        }
    
        public void setDate(Date date) {
            this.date = date;
        }
    
        public int getItemID() {
            return itemID;
        }
    
        public void setItemID(int itemID) {
            this.itemID = itemID;
        }
    
        public int getItemRating() {
            return itemRating;
        }
    
        public void setItemRating(int itemRating) {
            this.itemRating = itemRating;
        }
    
        public String getComment() {
            return comment;
        }
    
        public void setComment(String comment) {
            this.comment = comment;
        }
    }
    
    private class Restaurant {

        private int restaurantID;
        private String name;
        private String type;
        private String url;
    
        public Restaurant(int restaurantID, String name, String type, String url) {
            this.restaurantID = restaurantID;
            this.name = name;
            this.type = type;
            this.url = url;
        }
    
        public Restaurant() {
        }
    
        public int getRestaurantID() {
            return restaurantID;
        }
    
        public void setRestaurantID(int restaurantID) {
            this.restaurantID = restaurantID;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getType() {
            return type;
        }
    
        public void setType(String type) {
            this.type = type;
        }
    
        public String getUrl() {
            return url;
        }
    
        public void setUrl(String url) {
            this.url = url;
        }
    }
    

}
