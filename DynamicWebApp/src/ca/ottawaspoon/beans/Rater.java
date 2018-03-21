package ca.ottawaspoon.beans;

import java.sql.Date;

public class Rater {

    private String userID;
    private String password;
    private String email;
    private String name;
    private Date join_date;
    private String type;
    private int reputation;

    public Rater() {}

    public Rater(String userID, String password, String email, String name, Date join_date, String type, int reputation) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.name = name;
        this.join_date = join_date;
        this.type = type;
        this.reputation = reputation;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String eMail) {
        this.email = eMail;
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

    public String getPassword() { 
    		return password; 
    	}

    public void setPassword(String password) { 
    		this.password = password; 
    	}
    
}
