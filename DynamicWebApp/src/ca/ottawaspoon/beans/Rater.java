package ca.ottawaspoon.beans;

import java.sql.Date;
import java.util.ArrayList;

public class Rater {

    private int userID;
    private String password;
    private String eMail;
    private String name;
    private Date join_date;
    private int type;
    private int reputation;
    private ArrayList<Rating> ratings;

    public Rater() {
    }

    public Rater(int userID, String password, String eMail, String name, Date join_date, int type, int reputation) {
        this.userID = userID;
        this.password = password;
        this.eMail = eMail;
        this.name = name;
        this.join_date = join_date;
        this.type = type;
        this.reputation = reputation;
    }

    public Rater(int userID, String password, String eMail, String name, Date join_date, int type, int reputation, ArrayList<Rating> ratings) {
        this.userID = userID;
        this.password = password;
        this.eMail = eMail;
        this.name = name;
        this.join_date = join_date;
        this.type = type;
        this.reputation = reputation;
        this.ratings = ratings;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

