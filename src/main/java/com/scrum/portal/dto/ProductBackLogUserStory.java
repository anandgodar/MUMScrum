package com.scrum.portal.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_BACKLOG_USERSTORY")
public class ProductBackLogUserStory 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int productid;
	private int userStory_Id;
	private String userStory_Desc;
	
	//change to string type
	@Column(nullable=true)
	private int estimateEffort_Dev;
	
	@Column(nullable=true)
	private int estimateEffort_Test;
	
	@Column(nullable=true)
	private int actualEffort_Dev; //remaining effort 
	
	@Column(nullable=true)
	private int actualEffort_Test;
	
	@Column(nullable=true)
	private int developerID;
	
	@Column(nullable=true)
	private int testerID;
	
	@Column(nullable=true)
	private boolean assignedOrNot; 
	@Column(nullable=true)
	private String status;  //complete or Not update via update screen 
	
	
	@Column(nullable=true)
	private int releaseId; 
	
	@ManyToOne(optional=false)
	@JoinColumn(name="productid",referencedColumnName="id",insertable=false,updatable=false)
	private Product product;
	
	@Column(nullable=true)
	private int scrummasterid; 
	
	
	public int getScrummasterid() {
		return scrummasterid;
	}




	public void setScrummasterid(int scrummasterid) {
		this.scrummasterid = scrummasterid;
	}




	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}




	public int getReleaseId() {
		return releaseId;
	}




	public void setReleaseId(int releaseId) {
		this.releaseId = releaseId;
	}




	public int getSprintId() {
		return sprintId;
	}




	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}




	@Column(nullable=true)
	private int sprintId; 
	
	public ProductBackLogUserStory()
	{
		
	}

	
	
	
	public ProductBackLogUserStory(int product_BkLog_id, int userStory_Id, String userStory_Desc,
			int estimateEffort_Dev, int estimateEffort_Test, int actualEffort_Dev, int actualEffort_Test,
			int developer_ID, int tester_ID, boolean assignedOrNot, String status) {
		super();
		this.productid = product_BkLog_id;
		this.userStory_Id = userStory_Id;
		this.userStory_Desc = userStory_Desc;
		this.estimateEffort_Dev = estimateEffort_Dev;
		this.estimateEffort_Test = estimateEffort_Test;
		this.actualEffort_Dev = actualEffort_Dev;
		this.actualEffort_Test = actualEffort_Test;
		this.developerID = developer_ID;
		testerID = tester_ID;
		this.assignedOrNot = assignedOrNot;
		this.status = status;
	}




	public int getProductid() {
		return productid;
	}




	public void setProductid(int productid) {
		this.productid = productid;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public boolean isAssignedOrNot() {
		return assignedOrNot;
	}

	public void setAssignedOrNot(boolean assignedOrNot) {
		this.assignedOrNot = assignedOrNot;
	}

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserStory_Id() {
		return userStory_Id;
	}

	public void setUserStory_Id(int userStory_Id) {
		this.userStory_Id = userStory_Id;
	}

	public String getUserStory_Desc() {
		return userStory_Desc;
	}

	public void setUserStory_Desc(String userStory_Desc) {
		this.userStory_Desc = userStory_Desc;
	}

	public int getEstimateEffort_Dev() {
		return estimateEffort_Dev;
	}

	public void setEstimateEffort_Dev(int estimateEffort_Dev) {
		this.estimateEffort_Dev = estimateEffort_Dev;
	}

	public int getEstimateEffort_Test() {
		return estimateEffort_Test;
	}

	public void setEstimateEffort_Test(int estimateEffort_Test) {
		this.estimateEffort_Test = estimateEffort_Test;
	}

	public int getActualEffort_Dev() {
		return actualEffort_Dev;
	}

	public void setActualEffort_Dev(int actualEffort_Dev) {
		this.actualEffort_Dev = actualEffort_Dev;
	}

	public int getActualEffort_Test() {
		return actualEffort_Test;
	}

	public void setActualEffort_Test(int actualEffort_Test) {
		this.actualEffort_Test = actualEffort_Test;
	}

	

	public int getDeveloperID() {
		return developerID;
	}

	public void setDeveloperID(int developerID) {
		this.developerID = developerID;
	}




	public int getTesterID() {
		return testerID;
	}




	public void setTesterID(int testerID) {
		this.testerID = testerID;
	}




	
	
	
	
	
}