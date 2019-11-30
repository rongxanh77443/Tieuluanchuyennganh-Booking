package com.TLCN_BOOKING.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/helloJsp")
	public String init()
	{
		return "Index";
	}
}
