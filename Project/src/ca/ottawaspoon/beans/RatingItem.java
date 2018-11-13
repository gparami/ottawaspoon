package ca.ottawaspoon.beans;

import java.sql.Date;

public class RatingItem {

    private int userID;
    private Date date;
    private int itemID;
    private int itemRating;
    private String comment;

    public RatingItem(int userID, Date date, int itemID, int itemRating, String comment) {
        this.userID = userID;
        this.date = date;
        this.itemID = itemID;
        this.itemRating = itemRating;
        this.comment = comment;
    }

    public RatingItem() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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
