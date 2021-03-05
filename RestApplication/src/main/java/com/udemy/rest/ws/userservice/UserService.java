package com.udemy.rest.ws.userservice;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.udemy.rest.ws.model.request.UserDetailModelRequest;
import com.udemy.rest.ws.model.response.UserModel;

public interface UserService {
	UserModel createUser(UserDetailModelRequest userRequest);
}
