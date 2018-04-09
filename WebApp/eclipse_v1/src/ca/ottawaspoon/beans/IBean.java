package ca.ottawaspoon.beans;

public class IBean {

	String rest_name, rater_name;

	public IBean(String rest_name, String rater_name) {
		super();
		this.rest_name = rest_name;
		this.rater_name = rater_name;
	}
	public IBean() {
		super();
	}
	public String getRater_name() {
		return rater_name;
	}

	public void setRater_name(String rater_name) {
		this.rater_name = rater_name;
	}

	public String getRest_name() {
		return rest_name;
	}

	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	
}
