package com.udemy.rest.ws.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailModelRequest {
	@NotNull(message = "First Name should not be null")
	@Size(min = 2, message = "First Name should not be less than 2 characters")
	private String firstName;
	@NotNull(message = "Last Name should not be null")
	@Size(min = 2, message = "Last Name should not be less than 2 characters")
	private String lastName;

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
}
