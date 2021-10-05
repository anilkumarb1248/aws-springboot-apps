package com.sb.aws.beanstalk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/*")
public class UnmatchedEndpointsRequestHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UnmatchedEndpointsRequestHandler.class);

	@RequestMapping
	public ResponseEntity<String> acceptAll() {
		LOGGER.error("No endpoint found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requested end point not found!");
	}

}
