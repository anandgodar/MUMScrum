package com.scrum.portal.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SPRINT_USERSTORY")
public class SprintUserStory 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int sprint_UserStoryId;
	
	@ManyToOne
	@JoinColumn(name="sprint_Id", referencedColumnName="sprint_Id")
	private Sprint sprint;

	public SprintUserStory()
	{
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSprint_UserStoryId() {
		return sprint_UserStoryId;
	}

	public void setSprint_UserStoryId(int sprint_UserStoryId) {
		this.sprint_UserStoryId = sprint_UserStoryId;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
	

}
