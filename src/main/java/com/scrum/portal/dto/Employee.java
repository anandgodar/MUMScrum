package com.scrum.portal.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Employee")

//@SequenceGenerator(name="empSeq", initialValue=1, allocationSize=100)
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int employeeID; //all employees developer, tester, scrummaster
	
	private String firstName;
	private String lastName;
	
	
	/*@Transient
	private String password;*/
	private String email;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zip;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="employee")
	private User user;
	
	/*//for role mapping 
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employee")
	private List<EmployeeRole> EmployeeRoles;*/
	
	
	
	
	public Employee()
	{
		
	}

	/*public List<EmployeeRole> getEmployeeRoles() {
		return EmployeeRoles;
	}


	public void setEmployeeRoles(List<EmployeeRole> employeeRoles) {
		EmployeeRoles = employeeRoles;
	}*/



	public String getStreet() {
		return street;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	/*public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}*/


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
