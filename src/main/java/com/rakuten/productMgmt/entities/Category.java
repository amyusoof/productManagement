package com.rakuten.productMgmt.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Category implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5886144121263403998L;

	@Id
	@Column(name = "ID", nullable = false, precision = 22)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private Set<Product> productLists;

	@Column(name = "AISLE_ID", nullable = true)
	private long aisleId;

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

	public Set<Product> getProductLists() {
		return productLists;
	}

	public void setProductLists(Set<Product> productLists) {
		this.productLists = productLists;
	}

	public long getAisleId() {
		return aisleId;
	}

	public void setAisleId(long aisleId) {
		this.aisleId = aisleId;
	}
	
	
	
	

}
