package ca.ottawaspoon.beans;

import java.sql.Date;

public class KBean {

	private String user_name, rest_name;
	Date join_date, date;
	private Integer reputation, rating;
	
	public KBean(String user_name, Date join_date, String rest_name, Date date, Integer reputation,
			Integer rating) {
		super();
		this.user_name = user_name;
		this.join_date = join_date;
		this.rest_name = rest_name;
		this.date = date;
		this.reputation = reputation;
		this.rating = rating;
	}
	public KBean() {
		super();		
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getReputation() {
		return reputation;
	}
	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	
}
