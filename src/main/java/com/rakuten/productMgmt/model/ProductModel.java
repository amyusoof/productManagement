package com.rakuten.productMgmt.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rakuten.productMgmt.entities.Category;

public class ProductModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3241187826743375345L;
	private long id;
	
	private String name;
	
	private String desc;
	
	private Long price;
	
	private Boolean available;
	
	private long categoryId;
	
	private List<Category> categoriesList;
	
	private Map<Boolean,String> availableMap;
	
	public Map<Boolean,String> getAvailableMap() {
		this.availableMap= new HashMap<Boolean,String >();
		availableMap.put(true,"Yes" );
		availableMap.put(false,"No" );
		return availableMap;
	}

	public void setAvailableMap(Map<Boolean,String> availableMap) {
		this.availableMap = availableMap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public List<Category> getCategoriesList() {
		return categoriesList;
	}

	public void setCategoriesList(List<Category> categoriesList) {
		this.categoriesList = categoriesList;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	
	
}
