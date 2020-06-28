package com.TLCN_BOOKING.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TLCN_BOOKING.Services.countryService;


@Controller
public class MainController {
	
	@Autowired
	countryService countrySv;

	
	/*
	 * @GetMapping("/abc") public String init(HttpServletRequest request)
	 * 
	 * { request.setAttribute("listCountry", countrySv.findAllcountry()); return
	 * "LoginView/Index"; }
	 */
	@GetMapping("/login")
	public String login(){
		return "LoginView/Login";
	}
	

	/*
	 * @GetMapping("/register") public String register(){ return
	 * "LoginView/Register"; }
	 */
	
}
