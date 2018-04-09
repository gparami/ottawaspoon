package ca.ottawaspoon.beans;

public class RatBean {

	String name;
	Integer restaurantiD;
	Double positive_rating;
	public RatBean(String name, Integer restaurantiD, Double positive_rating) {
		super();
		this.name = name;
		this.restaurantiD = restaurantiD;
		this.positive_rating = positive_rating;
	}
	public RatBean() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRestaurantiD() {
		return restaurantiD;
	} 
	public void setRestaurantiD(Integer restaurantiD) {
		this.restaurantiD = restaurantiD;
	}
	public Double getPositive_rating() {
		return positive_rating;
	}
	public void setPositive_rating(Double positive_rating) {
		this.positive_rating = positive_rating;
	}
	
}
