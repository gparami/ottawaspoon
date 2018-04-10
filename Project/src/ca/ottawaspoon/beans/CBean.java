package ca.ottawaspoon.beans;

import java.sql.Date;

public class CBean {
	
	public CBean() {
		super();
	}
	public CBean(Date open_date, String name) {
		super();
		this.open_date = open_date;
		this.name = name;
	}
	private Date open_date;
	private String name;
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
