package ca.ottawaspoon.beans;

public class EBean {

	public EBean() {
		super();
	}
	public EBean(String type, String category, double avg) {
		super();
		this.type = type;
		this.category = category;
		this.avg = avg;
	}
	private String type;
	private String category;
	private double avg;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
