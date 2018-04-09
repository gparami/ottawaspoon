package ca.ottawaspoon.beans;

public class JBean {

	private String type;
	private Double ave_rating;
	public JBean(String type, Double ave_rating) {
		super();
		this.type = type;
		this.ave_rating = ave_rating;
	}
	public JBean() {
		super();
	}
	
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
