package com.TLCN_BOOKING.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.swing.tree.ExpandVetoException;

import org.mindrot.jbcrypt.BCrypt;
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
import com.TLCN_BOOKING.Services.roleService;
import com.TLCN_BOOKING.Services.routeService;
import com.TLCN_BOOKING.Services.seatService;
import com.TLCN_BOOKING.Services.sessionService;
import com.TLCN_BOOKING.models.Car;
import com.TLCN_BOOKING.models.Customer;
import com.TLCN_BOOKING.models.Manager;
import com.TLCN_BOOKING.models.Route;
import com.TLCN_BOOKING.models.Session;
import com.TLCN_BOOKING.models.User;

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

	@Autowired
	roleService roleSv;

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
						for (Session session : sessionSv.sessionRepository.findAllByCar(carSv.findById(deleteid))) {
							sessionSv.delete(session.getId());
						}
						seatSv.delete(carSv.findById(deleteid).getId());
						carSv.delete(deleteid);
						System.out.println("Id car sẽ xóa: " + deleteid);
						return "redirect:/car-list/" + userid;
					} else {
						for (Session session : sessionSv.findAllByRoute(routeSv.findById(deleteid))) {
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

	@GetMapping(value = "/save-regis-admin")
	public String addnew(HttpServletRequest request) {
		String userid = request.getParameter("userid");
		String action = request.getParameter("action");
		request.setAttribute("user", userService.findById(Integer.parseInt(userid)));
		if (action.equals("addnewaccount_user")) {
			System.out.println("Action: thêm user mới từ view managementusers");
			User user = new User();
			user.setUsername(request.getParameter("newusername"));
			user.setEmail(request.getParameter("newemail"));
			user.setPassword(BCrypt.hashpw(request.getParameter("newpassword"), BCrypt.gensalt()));
			user.setActive(1);
			String newnamerole = request.getParameter("newrole");
			System.out.println("User mới có role là: "+ newnamerole);
			user.setRoles(roleSv.findRoleByName(newnamerole));
			try {
				userService.saveUser(user);
				System.out.println("Đã lưu thành công user: " + user.getUsername());
				if (newnamerole.equals("Customer")) {
					System.out.println("user thêm mới là : " + newnamerole);
					Customer customer = new Customer();
					customer.setName(request.getParameter("newname"));
					customer.setDateofbirth(request.getParameter("newdateofbirth"));
					customer.setGender(request.getParameter("newgender"));
					customer.setCountry(request.getParameter("newcountry"));
					customer.setPhonenumber(request.getParameter("newphonenumber"));
					customer.setShowprofile(1);
					customer.setUser(user);
					try {
						customerSv.saveCustomer(customer);
						System.out.println("Đã lưu thành công customer: " + customer.getName());
						// Load lại trang
						request.setAttribute("nameofuser", user.getUsername());
						request.setAttribute("listUsers", userService.findAllUser());
						return "/AdminView/ManagementUsers";
					} catch (Exception e) {
						System.out.println("Không lưu thành công customer!!");
						userService.delete(user.getId());
					// Load lại trang
						request.setAttribute("nameofuser", user.getUsername());
						request.setAttribute("listUsers", userService.findAllUser());
						return "/AdminView/ManagementUsers";
					}

				}
				if (newnamerole.equals("Employees")) {
					System.out.println("user thêm mới là : " + newnamerole);
					Manager newmanager = new Manager();
					newmanager.setName(request.getParameter("newname"));
					newmanager.setDateofbirth(request.getParameter("newdateofbirth"));
					newmanager.setGender(request.getParameter("newgender"));
					newmanager.setPhonenumber(request.getParameter("newphonenumber"));
					newmanager.setShowprofile(1);
					newmanager.setUser(user);
					try {
						managerSv.saveManager(newmanager);
						System.out.println("Đã lưu thành công customer: " + newmanager.getName());
						// Load lại trang
						request.setAttribute("nameofuser", user.getUsername());
						request.setAttribute("listUsers", userService.findAllUser());
						return "/AdminView/ManagementUsers";
					} catch (Exception e) {
						System.out.println("Không lưu thành công customer: "+e);
						managerSv.delete(newmanager.getId());

						// Load lại trang
						request.setAttribute("nameofuser", user.getUsername());
						request.setAttribute("listUsers", userService.findAllUser());
						return "/AdminView/ManagementUsers";
					}
				}

			} catch (Exception e) {
				System.out.println("Không lưu được user: "+ e);
				// Load lại trang
				
				request.setAttribute("nameofuser", user.getUsername());
				request.setAttribute("listUsers", userService.findAllUser());
				return "/AdminView/ManagementUsers";
			}
		}
		
		request.setAttribute("nameofuser", userService.findById(Integer.parseInt(userid)).getUsername());
		request.setAttribute("listUsers", userService.findAllUser());
		return "/AdminView/ManagementCustomer";
		
	}

	@PostMapping(value = "/savenewcar")
	public String savenewcar(@RequestParam("object") String action, @RequestParam("userid") int userid,
			@RequestParam String carname, HttpServletRequest request) {
		Car car = new Car(carname);
		carSv.saveCar(car);
		request.setAttribute("user", userService.findById(userid));
		request.setAttribute("listcars", carSv.findAllCar());
		return "redirect:/car-list/" + userid;
	}

	@PostMapping(value = "/savenewroute")
	public String savenewroute(@RequestParam("object") String action, @RequestParam("userid") int userid,
			@RequestParam("carname") int carid, @RequestParam String startingpoint, @RequestParam String destination,
			@RequestParam String timestarting, @RequestParam String timeexpecting, @RequestParam int price,
			HttpServletRequest request) {
		Route route = new Route(startingpoint, destination, timestarting, timeexpecting, price, carid);
		routeSv.saveRoute(route);
		request.setAttribute("user", userService.findById(userid));
		request.setAttribute("listroutes", routeSv.findAllRoute());
		return "redirect:/route-list/" + userid;
	}
}
