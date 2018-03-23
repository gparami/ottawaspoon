package ca.ottawaspoon.beans;

import java.sql.Date;
import java.util.ArrayList;

public class Rater {

    private int userID;
    private String password;
    private String email;
    private String name;
    private Date join_date;
    private String type;
    private int reputation;
    private ArrayList<Rating> ratings;

    public Rater() {
    }

    public Rater(int userID, String password, String email, String name, Date join_date, String type, int reputation) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.name = name;
        this.join_date = join_date;
        this.type = type;
        this.reputation = reputation;
    }

    public Rater(int userID, String password, String email, String name, Date join_date, String type, int reputation, ArrayList<Rating> ratings) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.name = name;
        this.join_date = join_date;
        this.type = type;
        this.reputation = reputation;
        this.ratings = ratings;
    }

    public String getUserID() {
        return Integer.toString(userID);
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public void setUserID(String userID) {
        this.userID = Integer.parseInt(userID);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }
}

