package com.udemy.rest.ws.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.rest.ws.model.request.UpdateUserDetailModelRequest;
import com.udemy.rest.ws.model.request.UserDetailModelRequest;
import com.udemy.rest.ws.model.response.UserModel;
import com.udemy.rest.ws.userservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	Map<String, UserModel> user;

	@Autowired
	UserService userService;

	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page= " + page + " and limit= " + limit + " and sort is: " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserModel> getUser(@PathVariable String userId) {
		System.out.println("Reached get mapping");
		if (user.containsKey(userId)) {
			System.out.println("key in get mapping");
			return new ResponseEntity<UserModel>(user.get(userId), HttpStatus.OK);
		} else {
			System.out.println("key not in get mapping");
			return new ResponseEntity<UserModel>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserDetailModelRequest userRequest) {
		UserModel returnVal = userService.createUser(userRequest);
		return new ResponseEntity<UserModel>(returnVal, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public UserModel updateUser(@PathVariable String userId,
			@Valid @RequestBody UpdateUserDetailModelRequest userUpdateRequest) {
		UserModel response = user.get(userId);
		response.setFirstName(userUpdateRequest.getFirstName());
		response.setLastName(userUpdateRequest.getLastName());
		user.put(userId, response);
		return response;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		user.remove(id);
		return ResponseEntity.noContent().build();
	}
}
