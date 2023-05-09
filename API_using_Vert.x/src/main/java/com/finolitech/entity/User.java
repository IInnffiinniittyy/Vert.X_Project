package com.finolitech.entity;

import java.time.ZonedDateTime;

public class User {

	private Integer id;
	private String name;
	private String email;
	private Gender gender;
	private Status status;
	private ZonedDateTime timestamp;  // ZonedDateTime is a Java class that represents a date and time with a time zone.
	
	// No Argument constructor
	public User() {
		// TODO Auto-generated constructor stub
	}

	// All Argument constructor
	public User(Integer id, String name, String email, Gender gender, Status status, ZonedDateTime timestamp) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.timestamp = timestamp;
	}

	public User(String name, String email, Gender gender, Status status, ZonedDateTime timestamp) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.timestamp = timestamp;
	}

	// getters and setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

	// toString method
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", status=" + status
				+ ", timestamp=" + timestamp + "]";
	}
	
	
	
}
