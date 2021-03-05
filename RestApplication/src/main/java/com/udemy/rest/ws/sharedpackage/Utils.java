package com.udemy.rest.ws.sharedpackage;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
	public String generateUUID() {
		return UUID.randomUUID().toString();
	}
}
