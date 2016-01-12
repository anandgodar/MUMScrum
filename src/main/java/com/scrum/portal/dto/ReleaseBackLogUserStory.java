package com.scrum.portal.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RELEASE_BACKLOG_USERSTORY")
public class ReleaseBackLogUserStory 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int release_BckLog_UserStoryId;
	
	
	
	@ManyToOne
	@JoinColumn(name="releaseBckLog_Id", referencedColumnName="releaseBckLog_Id")
	private ReleaseBackLog releaseBackLog;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public ReleaseBackLog getReleaseBackLog() {
		return releaseBackLog;
	}
	public void setReleaseBackLog(ReleaseBackLog releaseBackLog) {
		this.releaseBackLog = releaseBackLog;
	}
	public int getRelease_BckLog_UserStoryId() {
		return release_BckLog_UserStoryId;
	}
	public void setRelease_BckLog_UserStoryId(int release_BckLog_UserStoryId) {
		this.release_BckLog_UserStoryId = release_BckLog_UserStoryId;
	}
	
	

}
