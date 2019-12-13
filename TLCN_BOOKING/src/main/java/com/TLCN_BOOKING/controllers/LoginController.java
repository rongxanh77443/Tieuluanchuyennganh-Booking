package com.TLCN_BOOKING.controllers;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TLCN_BOOKING.DAO.ManagerRepository;
import com.TLCN_BOOKING.Services.ManagerService;
import com.TLCN_BOOKING.Services.countryService;
import com.TLCN_BOOKING.Services.customerService;
import com.TLCN_BOOKING.Services.routeService;
import com.TLCN_BOOKING.Services.userService;
import com.TLCN_BOOKING.models.Customer;
import com.TLCN_BOOKING.models.User;

@Controller
public class LoginController {

	@Autowired
	userService userSv;
	
	@Autowired
	customerService customerSv;
	
	@Autowired
	ManagerService managerSv;
	
	@Autowired
	countryService countrySv;
	// <link rel="stylesheet" href="/css/bargan_shop.css" />

	@PostMapping("/save-regis")
	public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String name,
			@RequestParam String dateofbirth, @RequestParam String gender, @RequestParam String phonenumber,
			@RequestParam String country, @RequestParam String password, HttpServletRequest request) {

		User user = new User(username, email, password, 1, 3);
		userSv.saveUser(user);
		request.setAttribute("user", user);
		System.out.println("UserId vừa thêm mới: "+ user.getId());
		Customer customer = new Customer(name, dateofbirth, gender, phonenumber, 1,country,  user);		
		customerSv.saveCustomer(customer);

		return "LoginView/Login";
	}

	@PostMapping("/login-user")
	public String loginuser(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		if (userSv.findByUsernameAndPassword(username, password) != null) {
			request.setAttribute("user", userSv.findByUsernameAndPassword(username, password));

			if (userSv.findByUsernameAndPassword(username, password).getRoleuserid() == 1) {

				request.setAttribute("profile", managerSv.findByUser((userSv.findByUsernameAndPassword(username, password))));
				request.setAttribute("listUsers", userSv.findAllUser());
				return "AdminView/ManagementUsers"; // Admin
			} else if (userSv.findByUsernameAndPassword(username, password).getRoleuserid() == 2) {
				request.setAttribute("profile", managerSv.findByUser((userSv.findByUsernameAndPassword(username, password))));
				return "AdminView/ManagementSeller"; // Seller
			} else {
				request.setAttribute("profile",
						customerSv.findByUser(userSv.findByUsernameAndPassword(username, password)));
				request.setAttribute("listCountry", countrySv.findAllcountry());
				return "CustomerView/Home"; // Customer
			}
		} else {
			return "LoginView/Login";
		}

	}
}
