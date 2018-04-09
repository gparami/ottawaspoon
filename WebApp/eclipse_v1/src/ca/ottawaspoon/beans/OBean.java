package ca.ottawaspoon.beans;

public class OBean {
	
	private Double dev;
	private Integer food;
	
	private String userid, user_name, type, e_mail, rest_name;
	
	public OBean(String userid, Double dev, String user_name, String type, String e_mail,  Integer food, String rest_name) {
		super();
		this.userid = userid;
		this.user_name = user_name;
		this.type = type;
		this.e_mail = e_mail;
		this.rest_name = rest_name;
		this.dev = dev;
		this.food = food;
	}
	public OBean() {
		super();
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public Double getDev() {
		return dev;
	}
	public void setDev(Double dev) {
		this.dev = dev;
	}
	public Integer getFood() {
		return food;
	}
	public void setFood(Integer food) {
		this.food = food;
	}


}
