package com.TLCN_BOOKING.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMainController {
	@GetMapping("/")
	public String hello() {
		return "Hello World";
	}
}
