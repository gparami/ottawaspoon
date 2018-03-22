package ca.ottawaspoon.beans;

import java.util.ArrayList;

public class Restaurant {

    private int restaurantID;
    private String name;
    private String type;
    private String url;
    private ArrayList<Location> locations;

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
