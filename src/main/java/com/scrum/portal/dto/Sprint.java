package com.scrum.portal.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
=======
import javax.persistence.OneToMany;
>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35
import javax.persistence.Table;


@Entity
@Table(name = "sprint")
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
<<<<<<< HEAD
	private String name;
	private String description;
	private int releaseid;

	public int getReleaseid() { 
		return releaseid;
	}
	public void setReleaseid(int releaseid) {
		this.releaseid = releaseid;
	}
=======
	private int sprint_Id; //newly added 
	private String name;
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="sprint")
	private List<SprintUserStory> sprintUserStory; //newly added
	
>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35
	public Sprint(){
		super();
	}
	public Sprint(String name,String description)
	{
		this.name = name;
		this.description = description;
	
	}
	
<<<<<<< HEAD
	@OneToOne
	@JoinColumn(name="id")
	private ReleaseBacklog releaseBacklog;
	
	public ReleaseBacklog getReleaseBacklog() {
		return releaseBacklog;
	}
	public void setReleaseBacklog(ReleaseBacklog releaseBacklog) {
		this.releaseBacklog = releaseBacklog;
	}
=======
	
	public List<SprintUserStory> getSprintUserStory() {
		return sprintUserStory;
	}
	public void setSprintUserStory(List<SprintUserStory> sprintUserStory) {
		this.sprintUserStory = sprintUserStory;
	}
	public int getSprint_Id() {
		return sprint_Id;
	}
	public void setSprint_Id(int sprint_Id) {
		this.sprint_Id = sprint_Id;
	}
	
>>>>>>> be6682e89d3bddcfc4f1dd051f0dc6a0f399ee35
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

}