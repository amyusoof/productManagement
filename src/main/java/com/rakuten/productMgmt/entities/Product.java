package com.rakuten.productMgmt.entities;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3124512519168557882L;

	@Id
	@Column(name = "ID", nullable = false, precision = 22)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	@Column(name = "PRICE", nullable = true)
	private Long price;

	@Column(name = "AVAILABLE", nullable = true)
	private Boolean available;

	@ManyToOne(targetEntity = Category.class, optional = false)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
