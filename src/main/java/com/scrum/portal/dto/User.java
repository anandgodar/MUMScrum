package com.scrum.portal.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
@SequenceGenerator(name="userSeq", initialValue=1, allocationSize=100)
public class User 
{
	/*@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSeq")*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	

	private String userName;
	private String password;
	private int roleID;
	
	
	@OneToOne
	@JoinColumn(name="employeeID")
	private Employee employee;
	
	public User()
	{
		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public int getRoleID() {
		return roleID;
	}



	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}



	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	

}
