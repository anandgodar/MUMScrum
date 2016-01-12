package com.scrum.portal.model;

import java.util.Date;


public class ReleaseFormBean {

	
	private int id;
	private String name;
	private String description;
	private int productId; 
	private Date createdOn;
	private int createdBy;
	

	
	
	public ReleaseFormBean(){
		super();
	}
	
	
	
	public ReleaseFormBean(String name, String description, int productId, Date createdOn, int createdBy) {
		super();
		this.name = name;
		this.description = description;
		this.productId = productId;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public int getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	
	
}