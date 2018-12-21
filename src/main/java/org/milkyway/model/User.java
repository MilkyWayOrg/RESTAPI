package org.milkyway.model;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	
	private String id;
	@Size(min=3,message="First Name Must be atleast 3 chars")
	private String firstName;
	
	private String lastName;
	
	@Pattern(regexp="^[a-zA-Z0-9._]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",message="Provide Valid Email ID")
	private String emailId;
	
	@Pattern(regexp="",message="Invalid Role,must be one of these values ['SYSTEM_ADMIN','PROJECT_ADMIN','ORG_OWNER','PROJECT_MANAGER','DEVELOPER','TESTER'] ")
	private List<String> role;
	
	@Size(min=3,message="First Name Must be atleast 3 chars")
	private String org;
	
	private List<String> project;
	private List<String> applications;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(String id, @Size(min = 3, message = "First Name Must be atleast 3 chars") String firstName,
			String lastName,
			@Pattern(regexp = "^[a-zA-Z0-9._]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "Provide Valid Email ID") String emailId,
			@Pattern(regexp = "", message = "Invalid Role,must be one of these values ['SYSTEM_ADMIN','PROJECT_ADMIN','ORG_OWNER','PROJECT_MANAGER','DEVELOPER','TESTER'] ") List<String> role,
			@Size(min = 3, message = "First Name Must be atleast 3 chars") String org, List<String> project,
			List<String> applications) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.role = role;
		this.org = org;
		this.project = project;
		this.applications = applications;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public List<String> getRole() {
		return role;
	}


	public void setRole(List<String> role) {
		this.role = role;
	}


	public String getOrg() {
		return org;
	}


	public void setOrg(String org) {
		this.org = org;
	}


	public List<String> getProject() {
		return project;
	}


	public void setProject(List<String> project) {
		this.project = project;
	}


	public List<String> getApplications() {
		return applications;
	}


	public void setApplications(List<String> applications) {
		this.applications = applications;
	}
	

	
	
	
}
