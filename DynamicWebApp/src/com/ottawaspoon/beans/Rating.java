package com.ottawaspoon.beans;

import java.sql.Date;

public class Rating {

    private int userId;
    private Date date;
    private int price;
    private int food;
    private int mood;
    private int staff;
    private String comment;
    private int restaurantID;

    public Rating(int userId, Date date, int price, int food, int mood, int staff, String comment, int restaurantID) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
