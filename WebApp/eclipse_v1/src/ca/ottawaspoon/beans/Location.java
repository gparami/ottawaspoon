package ca.ottawaspoon.beans;

import java.sql.Date;

public class Location {

    private int locationID;
    private Date open_date;
    private String manager;
    private String phone;
    private String address;
    private Integer hours_open;
    private Integer hours_close;
    private int restaurantID;

    public Location(int locationID, Date open_date, String manager, String phone, String address, Integer hours_open, Integer hours_close, int restaurantID) {
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

    public Integer getHours_open() {
        return hours_open;
    }

    public void setHours_open(Integer hours_open) {
        this.hours_open = hours_open;
    }

    public Integer getHours_close() {
        return hours_close;
    }

    public void setHours_close(Integer hours_close) {
        this.hours_close = hours_close;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
}
