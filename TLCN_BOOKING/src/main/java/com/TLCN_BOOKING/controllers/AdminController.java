package com.TLCN_BOOKING.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TLCN_BOOKING.Services.ManagerService;
import com.TLCN_BOOKING.Services.UserService_1;
import com.TLCN_BOOKING.Services.carService;
import com.TLCN_BOOKING.Services.customerService;
import com.TLCN_BOOKING.Services.routeService;
import com.TLCN_BOOKING.Services.seatService;
import com.TLCN_BOOKING.Services.sessionService;
import com.TLCN_BOOKING.models.Car;
import com.TLCN_BOOKING.models.Route;
import com.TLCN_BOOKING.models.Session;

@Controller
public class AdminController {

	static int id = 0;;

	@Autowired
	ManagerService managerSv;

	@Autowired
	customerService customerSv;

	@Autowired
	UserService_1 userService;
//	userService userService;

	@Autowired
	routeService routeSv;

	@Autowired
	carService carSv;

	@Autowired
	seatService seatSv;

	@Autowired
	sessionService sessionSv;

	
	
	@GetMapping(value = "/profile/{id}")
	public String profile(@PathVariable("id") String userid, HttpServletRequest request) {
		request.setAttribute("user", userService.findById(Integer.parseInt(userid)));
		request.setAttribute("profile", managerSv.findByUser(userService.findById(Integer.parseInt(userid))));
		return "AdminView/profile";
	}

	@GetMapping(value = "/user-list/{id}")
	public String userlist(@PathVariable("id") String userid, HttpServletRequest request) {
		request.setAttribute("user", userService.findById(Integer.parseInt(userid)));
		request.setAttribute("listUsers", userService.findAllUser());
		return "AdminView/ManagementUsers";
	}

	@GetMapping(value = "/seller-list/{id}")
	public String sellerlist(@PathVariable("id") String userid, HttpServletRequest request) {

		request.setAttribute("user", userService.findById(Integer.parseInt(userid)));
		request.setAttribute("listmanager", managerSv.findAllManager());

		return "AdminView/ManagementSeller";
	}

	@GetMapping(value = "/customer-list/{id}")
	public String customerlist(@PathVariable("id") String userid, HttpServletRequest request) {
		request.setAttribute("user", userService.findById(Integer.parseInt(userid)));
		request.setAttribute("listcustomer", customerSv.findAllCustomer());
		return "AdminView/ManagementCustomer";
	}

	@GetMapping(value = "/car-list/{id}")
	public String carslist(@PathVariable("id") String userid, HttpServletRequest request) {
		request.setAttribute("user", userService.findById(Integer.parseInt(userid)));
		request.setAttribute("listcars", carSv.findAllCar());
		return "AdminView/ManagementCar";
	}

	@GetMapping(value = "/route-list/{id}")
	public String routeslist(@PathVariable("id") String userid, HttpServletRequest request) {
		request.setAttribute("user", userService.findById(Integer.parseInt(userid)));
		request.setAttribute("listRoutes", routeSv.findAllRoute());
		return "AdminView/ManagementRoute";
	}

	/*
	 * @GetMapping(value = "/edit/{userid}/{usersid}/{action}") public String
	 * edituser(@PathVariable("userid") int userid, @PathVariable("usersid") int
	 * usersid,
	 * 
	 * @PathVariable("action") String action, HttpServletRequest request) {
	 * System.out.println("Action edit la:   " + action);
	 * request.setAttribute("user", userService.findById(userid)); if
	 * (action.equals("user")) { request.setAttribute("users",
	 * userService.findById(usersid)); if ((userService.findById(usersid).getRoleuserid() == 1
	 * || userService.findById(usersid).getRoleuserid() == 2)) {
	 * System.out.println("Edit Manager: " +
	 * managerSv.findByUser(userService.findById(usersid)).getName());
	 * request.setAttribute("profile",
	 * managerSv.findByUser(userService.findById(usersid)));
	 * System.out.println(managerSv.findByUser(userService.findById(usersid)).getName() +
	 * "     :Name Manager Choosed"); request.setAttribute("role", 1); if
	 * (userService.findById(usersid).getRoleuserid() == 1)
	 * request.setAttribute("rolename", "Admin"); else
	 * request.setAttribute("rolename", "Seller"); } else {
	 * System.out.println("Edit customer: " +
	 * customerSv.findByUser(userService.findById(usersid)).getName());
	 * request.setAttribute("role", 3); request.setAttribute("profile",
	 * customerSv.findByUser(userService.findById(usersid)));
	 * request.setAttribute("rolename", "Customer"); }
	 * System.out.println(userService.findById(usersid).getRoleuserid() +
	 * "     :RoleUserid Choosed"); } if (action.equals("manager")) {
	 * request.setAttribute("users",
	 * userService.findById(managerSv.findById(usersid).getUser().getId()));
	 * System.out.println("Edit Manager: " + managerSv.findById(usersid).getName());
	 * request.setAttribute("profile", managerSv.findById(usersid));
	 * request.setAttribute("role", 1); if (userService.findById(usersid).getRoleuserid()
	 * == 1) request.setAttribute("rolename", "Admin"); else
	 * request.setAttribute("rolename", "Seller"); } if (action.equals("customer"))
	 * { request.setAttribute("users",
	 * userService.findById(customerSv.findById(usersid).getUser().getId()));
	 * System.out.println("Edit customer: " +
	 * customerSv.findById(usersid).getName()); request.setAttribute("role", 3);
	 * request.setAttribute("profile", customerSv.findById(usersid));
	 * request.setAttribute("rolename", "Customer"); }
	 * 
	 * return "AdminView/Edit"; }
	 */

	@GetMapping(value = "/edit2/{userid}/{nousersid}/{action}")
	public String editnopeople(@PathVariable("userid") int userid, @PathVariable("nousersid") int nousersid,
			@PathVariable("action") String action, HttpServletRequest request) {

		request.setAttribute("user", userService.findById(userid));
		if (action == "car") {
			System.out.println("Carid Choosed: " + nousersid);
			request.setAttribute("cars", carSv.findById(nousersid));
			request.setAttribute("object", "car");
		}
		if (action == "route") {
			System.out.println("Routeid Choosed: " + nousersid);
			request.setAttribute("routes", routeSv.findById(nousersid));
			request.setAttribute("object", "route");
		}
		return "AdminView/Edit";
	}

	/*
	 * @PostMapping(value = "/save-user") public String saveuser(@RequestParam int
	 * userid, @RequestParam String profileid, @RequestParam String usersid,
	 * 
	 * @RequestParam String username, @RequestParam String email, @RequestParam
	 * String name,
	 * 
	 * @RequestParam String dateofbirth, @RequestParam String gender, @RequestParam
	 * String phonenumber,
	 * 
	 * @RequestParam String country, @RequestParam String showprofile, @RequestParam
	 * String password,
	 * 
	 * @RequestParam("roleuser") String roleuser, HttpServletRequest request) {
	 * request.setAttribute("user", userService.findById(userid)); User user =
	 * userService.findById(Integer.parseInt(usersid)); user.setUsername(username);
	 * user.setPassword(password); user.setEmail(email); if (roleuser == "Admin")
	 * user.setRoleuserid(1); if (roleuser == "Seller") user.setRoleuserid(2); if
	 * (roleuser == "Customer") user.setRoleuserid(3);
	 * 
	 * System.out.println(roleuser + "  :roleuser"); user.setActive(1);
	 * userService.saveUser(user);
	 * 
	 * if (userService.findById(Integer.parseInt(usersid)).getRoleuserid() == 1 ||
	 * userService.findById(Integer.parseInt(usersid)).getRoleuserid() == 2) {
	 * 
	 * Manager manager = managerSv.findByUser(user); manager.setName(name);
	 * manager.setDateofbirth(dateofbirth); manager.setGender(gender);
	 * manager.setPhonenumber(phonenumber);
	 * manager.setShowprofile(Integer.parseInt(showprofile)); manager.setUser(user);
	 * managerSv.saveManager(manager); } else { Customer customer =
	 * customerSv.findByUser(user); customer.setName(name);
	 * customer.setDateofbirth(dateofbirth); customer.setGender(gender);
	 * customer.setPhonenumber(phonenumber);
	 * customer.setShowprofile(Integer.parseInt(showprofile));
	 * customer.setUser(user); customer.setCountry(country);
	 * customerSv.saveCustomer(customer); } return "redirect:/user-list/" + userid;
	 * 
	 * }
	 */
	@GetMapping(value = "/delete/{userid}/{id}/{action}")
	public String delete(@PathVariable("userid") int userid, @PathVariable("action") String action,
			@PathVariable("id") int deleteid, HttpServletRequest request) {
		System.out.println("Action: delete " + action);
		request.setAttribute("user", userService.findById(userid));
		if (action.equals("user")) {
			userService.delete(deleteid);
			System.out.println("Id user sẽ xóa: " + deleteid);
			return "redirect:/user-list/" + userid;
		} else {
			if (action.equals("manager")) {
				if (managerSv.findById(deleteid).getId() != 1) {
					userService.delete(userService.findById(managerSv.findById(deleteid).getUser().getId()).getId());
					managerSv.delete(deleteid);
					System.out.println("Id manager sẽ xóa: " + deleteid);
				}
				return "redirect:/seller-list/" + userid;

			} else {
				if (action.equals("customer")) {

					userService.delete(userService.findById(customerSv.findById(deleteid).getUser().getId()).getId());
					managerSv.delete(deleteid);
					System.out.println("Id customer sẽ xóa: " + deleteid);
					return "redirect:/customer-list/" + userid;
				} else {
					if (action.equals("car")) {
						for (Session session : sessionSv.sessionRepository.findAllByCar(carSv.findById(deleteid))){
							sessionSv.delete(session.getId());
						}
						seatSv.delete(carSv.findById(deleteid).getId());
						carSv.delete(deleteid);
						System.out.println("Id car sẽ xóa: " + deleteid);
						return "redirect:/car-list/" + userid;
					} else {
						for (Session session : sessionSv.findAllByRoute(routeSv.findById(deleteid))){
							sessionSv.delete(session.getId());
						}
						routeSv.delete(deleteid);
						System.out.println("Id route sẽ xóa: " + deleteid);
						return "redirect:/route-list/" + userid;
					}
				}
			}
		}
	}

	@GetMapping(value = "/add/{userid}/{action}")
	public String addnew(@PathVariable("userid") int userid, @PathVariable("action") String action,
			HttpServletRequest request) {
		request.setAttribute("user", userService.findById(userid));
		request.setAttribute("userid", userid);
		if (action.equals("user") || action.equals("customer"))
			return "redirect:/register";
		if (action.equals("seller")) {
			request.setAttribute("action", "seller");
		}
		if (action.equals("route")) {
			request.setAttribute("action", "route");
		}
		if (action.equals("car")) {
			request.setAttribute("action", "car");
		}
		return "/AdminView/New";
	}

	/*
	 * @PostMapping(value="/savenewmanager") public String
	 * savenewmanager(@RequestParam("object") String action, @RequestParam("userid")
	 * int userid,
	 * 
	 * @RequestParam String username, @RequestParam String email, @RequestParam
	 * String name,
	 * 
	 * @RequestParam String dateofbirth, @RequestParam String gender, @RequestParam
	 * String phonenumber,
	 * 
	 * @RequestParam String password, HttpServletRequest request) { User user =new
	 * User(username,email,password,1,2); userService.saveUser(user); Manager manager=new
	 * Manager(name,dateofbirth,gender,phonenumber,1,user);
	 * managerSv.saveManager(manager); request.setAttribute("user",
	 * userService.findById(userid)); System.out.println("Action them moi acmin!");
	 * request.setAttribute("listmanager", managerSv.findAllManager()); return
	 * "redirect:/seller-list/"+userid; }
	 */
	@PostMapping(value="/savenewcar")
	public String savenewcar(@RequestParam("object") String action, @RequestParam("userid") int userid,@RequestParam String carname,HttpServletRequest request) {
		Car car=new Car(carname);
		carSv.saveCar(car);
		request.setAttribute("user", userService.findById(userid));
		request.setAttribute("listcars", carSv.findAllCar());
		return "redirect:/car-list/"+userid;
	}
	@PostMapping(value="/savenewroute")
	public String savenewroute(@RequestParam("object") String action, @RequestParam("userid") int userid,@RequestParam("carname") int carid, @RequestParam String startingpoint,@RequestParam String destination, @RequestParam String timestarting, @RequestParam String timeexpecting, @RequestParam int price,
			HttpServletRequest request) {
		Route route =new Route(startingpoint,destination,timestarting,timeexpecting,price,carid);
		routeSv.saveRoute(route);
		request.setAttribute("user", userService.findById(userid));
		request.setAttribute("listroutes", routeSv.findAllRoute());
		return "redirect:/route-list/"+userid;
	}
}
