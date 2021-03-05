package com.udemy.rest.ws.userservice.implement;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.rest.ws.model.request.UserDetailModelRequest;
import com.udemy.rest.ws.model.response.UserModel;
import com.udemy.rest.ws.sharedpackage.Utils;
import com.udemy.rest.ws.userservice.UserService;

@Service
public class UserServiceImp implements UserService {
	Map<String, UserModel> user;
	Utils utils;

	public UserServiceImp() {
	}

	@Autowired
	public UserServiceImp(Utils utils) {
		this.utils = utils;
	}
	@Override
	public UserModel createUser(UserDetailModelRequest userRequest) {
		UserModel response = new UserModel();
		response.setEmail(userRequest.getEmail());
		response.setFirstName(userRequest.getFirstName());
		response.setLastName(userRequest.getLastName());
		// response.setUserId(userRequest.getUserId());
		String userId = utils.generateUUID();
		response.setUserId(userId);
		if (user == null) {
			user = new HashMap<>();
			user.put(userId, response);
		}
		for (Object objectName : user.keySet()) {
			System.out.println(objectName);
			System.out.println(user.get(objectName).getEmail());
		}
		return response;
	}

}
