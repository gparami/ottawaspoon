package ca.ottawaspoon.beans;

public class NBean {

	private String name, e_mail;

	public NBean(String name, String e_mail) {
		super();
		this.name = name;
		this.e_mail = e_mail;
	}
	public NBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
}
