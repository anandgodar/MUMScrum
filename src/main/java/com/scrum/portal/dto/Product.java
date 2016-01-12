package com.scrum.portal.dto;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private String createdDate;
	private String createdBy;
	private int productBacklogId;

	public int getProductBacklogId() {
		return productBacklogId;
	}

	public void setProductBacklogId(int productBacklogId) {
		this.productBacklogId = productBacklogId;
	}

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public Product(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@OneToMany(mappedBy="product",targetEntity=ProductBackLogUserStory.class, fetch=FetchType.EAGER)
    private List<ProductBackLogUserStory> UserStory;

	public List<ProductBackLogUserStory> getUserStory() {
		return UserStory;
	}

	public void setUserStory(List<ProductBackLogUserStory> userStory) {
		UserStory = userStory;
	}

	

}
