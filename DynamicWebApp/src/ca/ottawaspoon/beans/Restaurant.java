package ca.ottawaspoon.beans;

import java.util.ArrayList;

public class Restaurant {

    private int restaurantID;
    private String name;
    private String type;
    private String url;
    private ArrayList<Location> locations;
    private ArrayList<MenuItem> menuItems;
    private ArrayList<Rating> ratings;

    public Restaurant(int restaurantID, String name, String type, String url) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.type = type;
        this.url = url;
    }

    public Restaurant(int restaurantID, String name, String type, String url, ArrayList<Location> locations, ArrayList<MenuItem> menuItems, ArrayList<Rating> ratings) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.type = type;
        this.url = url;
        this.locations = locations;
        this.menuItems = menuItems;
        this.ratings = ratings;
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

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }
}