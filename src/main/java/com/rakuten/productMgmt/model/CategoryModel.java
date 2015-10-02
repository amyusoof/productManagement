package com.rakuten.productMgmt.model;

import java.io.Serializable;

public class CategoryModel implements Serializable{

	
	private static final long serialVersionUID = -8262789140572238745L;
	
	private String name;
	
	private String description;
	
	private long id;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	 

}
