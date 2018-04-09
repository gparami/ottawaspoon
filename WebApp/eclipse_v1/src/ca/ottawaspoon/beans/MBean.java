package ca.ottawaspoon.beans;

public class MBean {

	private String user_name, comment, dish_name;
	private Integer reputation, price;
	
	public MBean(String user_name, String comment, String dish_name, Integer reputation, Integer price) {
		super();
		this.user_name = user_name;
		this.comment = comment;
		this.dish_name = dish_name;
		this.reputation = reputation;
		this.price = price;
	}
	public MBean() {
		super();
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public Integer getReputation() {
		return reputation;
	}
	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
