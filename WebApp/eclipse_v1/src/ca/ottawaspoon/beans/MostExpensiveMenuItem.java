package ca.ottawaspoon.beans;

public class MostExpensiveMenuItem {
	
	public MostExpensiveMenuItem() {
		super();
	}

	private String restaurant;
	private String menuItem;
	private String manager;
	private int price;
	private String url;
	private int hours_open;
	
	public MostExpensiveMenuItem(String restaurant, String menuItem, String manager, int price, String url,
			int hours_open) {
		super();
		this.restaurant = restaurant;
		this.menuItem = menuItem;
		this.manager = manager;
		this.price = price;
		this.url = url;
		this.hours_open = hours_open;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getHours_open() {
		return hours_open;
	}

	public void setHours_open(int hours_open) {
		this.hours_open = hours_open;
	}
	
	
	
	
}
