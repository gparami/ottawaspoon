package ca.ottawaspoon.beans;

public class JBean {

	String type;
	public JBean(String type, Double ave_rating) {
		super();
		this.type = type;
		this.ave_rating = ave_rating;
	}
	public JBean() {
		super();
	}
	Double ave_rating;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getAve_rating() {
		return ave_rating;
	}
	public void setAve_rating(Double ave_rating) {
		this.ave_rating = ave_rating;
	}
	
}
