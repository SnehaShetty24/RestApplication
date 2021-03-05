package com.udemy.rest.ws.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailModelRequest {
	@NotNull(message = "First Name should not be null")
	@Size(min = 2, message = "First Name should not be less than 2 characters")
	private String firstName;
	@NotNull(message = "Last name cannot be null")
	@Size(min = 2, message = "Last name must not be less than 2 characters")
	private String lastName;
	@NotNull(message = "Email cannot be null")
	@Email
	private String email;
	@NotNull
	@Size(min = 5, message = "User Id should not be less than 5 characters and greater than 10 characters")
	private String userId;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
