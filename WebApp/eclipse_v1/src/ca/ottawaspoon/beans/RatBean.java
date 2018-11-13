package ca.ottawaspoon.beans;

public class RatBean {

	Integer id;
	String restaurantiD;
	Double positive_rating;
	public RatBean(Integer id, String restaurantiD, Double positive_rating) {
		super();
		this.id = id;
		this.restaurantiD = restaurantiD;
		this.positive_rating = positive_rating;
	}
	public RatBean() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRestaurantiD() {
		return restaurantiD;
	} 
	public void setRestaurantiD(String restaurantiD) {
		this.restaurantiD = restaurantiD;
	}
	public Double getPositive_rating() {
		return positive_rating;
	}
	public void setPositive_rating(Double positive_rating) {
		this.positive_rating = positive_rating;
	}
	
}
