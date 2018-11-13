package ca.ottawaspoon.beans;

public class GBean {
	
	private String name, type, phone;
	
	public GBean(String name, String type, String phone) {
		super();
		this.name = name;
		this.type = type;
		this.phone = phone;
	}

	public GBean() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
