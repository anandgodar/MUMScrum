package com.scrum.portal.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//@Entity
//@Table(name = "userstory")
public class UserStory1 {
	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String description;
	private int developerid;
	private int testerid;
	private int developerestimatedtime;
	private int testerestimatedtime;
	private int developeractualtime;
	private int testeractualtime;
	
	//@Column(nullable=false)
	private int releaseid;
	
	//@Column(nullable=false)
	private int productid;
	//@Column(nullable=false)
	private int sprintid;
	
	
	//@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="id")
	private Sprint sprint;
	

	//@ManyToOne(optional=false)
	//@JoinColumn(name="productid",referencedColumnName="id",insertable=false,updatable=false)
	private Product product;
	
	//@OneToOne
	//@JoinColumn(name="id")
	private ReleaseBacklog releasebacklog;
	
	
	private String title;
	public String getTitle() {
		return title;
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

	public int getDeveloperid() {
		return developerid;
	}

	public void setDeveloperid(int developerid) {
		this.developerid = developerid;
	}

	public int getTesterid() {
		return testerid;
	}

	public void setTesterid(int testerid) {
		this.testerid = testerid;
	}

	public int getDeveloperestimatedtime() {
		return developerestimatedtime;
	}

	public void setDeveloperestimatedtime(int developerestimatedtime) {
		this.developerestimatedtime = developerestimatedtime;
	}

	public int getTesterestimatedtime() {
		return testerestimatedtime;
	}

	public void setTesterestimatedtime(int testerestimatedtime) {
		this.testerestimatedtime = testerestimatedtime;
	}

	public int getDeveloperactualtime() {
		return developeractualtime;
	}

	public void setDeveloperactualtime(int developeractualtime) {
		this.developeractualtime = developeractualtime;
	}

	public int getTesteractualtime() {
		return testeractualtime;
	}

	public void setTesteractualtime(int testeractualtime) {
		this.testeractualtime = testeractualtime;
	}


	public UserStory1()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReleaseid() {
		return releaseid;
	}

	public void setReleaseid(int releaseid) {
		this.releaseid = releaseid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getSprintid() {
		return sprintid;
	}

	public void setSprintid(int sprintid) {
		this.sprintid = sprintid;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ReleaseBacklog getReleasebacklog() {
		return releasebacklog;
	}

	public void setReleasebacklog(ReleaseBacklog releasebacklog) {
		this.releasebacklog = releasebacklog;
	}
	

	

}
