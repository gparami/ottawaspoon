package ca.ottawaspoon.beans;

public class Ratings {
	
	private String restaurantName;
	private String raterName;
	private double averageScore;
	private int noOfRatings;
	
	public Ratings(String restaurantName, String raterName, double averageScore, int noOfRatings) {
		super();
		this.restaurantName = restaurantName;
		this.raterName = raterName;
		this.averageScore = averageScore;
		this.noOfRatings = noOfRatings;
	}
	public Ratings() {
		super();
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRaterName() {
		return raterName;
	}
	public void setRaterName(String raterName) {
		this.raterName = raterName;
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	public int getNoOfRatings() {
		return noOfRatings;
	}
	public void setNoOfRatings(int noOfRatings) {
		this.noOfRatings = noOfRatings;
	}
	
}
