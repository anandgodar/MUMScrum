package com.scrum.portal.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RELEASE_BACKLOG")
public class ReleaseBackLog 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;  //primary key 
	
	private int releaseBckLog_Id;
	private int product_BkLog_id; //PRODUCT ID MATCH WITH RELEASE
	private String release_Title;
	private String release_desc;
	private String scrum_Master;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="releaseBackLog")
	private List<ReleaseBackLogUserStory> releaseBackLogUserStory;
	
	
	public ReleaseBackLog()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getScrum_Master() {
		return scrum_Master;
	}

	public void setScrum_Master(String scrum_Master) {
		this.scrum_Master = scrum_Master;
	}

	public List<ReleaseBackLogUserStory> getReleaseBackLogUserStory() {
		return releaseBackLogUserStory;
	}

	public void setReleaseBackLogUserStory(List<ReleaseBackLogUserStory> releaseBackLogUserStory) {
		this.releaseBackLogUserStory = releaseBackLogUserStory;
	}

	public int getReleaseBckLog_Id() {
		return releaseBckLog_Id;
	}

	public void setReleaseBckLog_Id(int releaseBckLog_Id) {
		this.releaseBckLog_Id = releaseBckLog_Id;
	}

	public int getProduct_BkLog_id() {
		return product_BkLog_id;
	}

	public void setProduct_BkLog_id(int product_BkLog_id) {
		this.product_BkLog_id = product_BkLog_id;
	}

	public String getRelease_Title() {
		return release_Title;
	}

	public void setRelease_Title(String release_Title) {
		this.release_Title = release_Title;
	}

	public String getRelease_desc() {
		return release_desc;
	}

	public void setRelease_desc(String release_desc) {
		this.release_desc = release_desc;
	}

	
	

}
