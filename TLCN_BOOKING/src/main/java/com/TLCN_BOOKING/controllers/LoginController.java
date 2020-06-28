package com.TLCN_BOOKING.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TLCN_BOOKING.Services.GoogleUtils;
import com.TLCN_BOOKING.Services.ManagerService;
import com.TLCN_BOOKING.Services.UserDetailsServiceImpl;
import com.TLCN_BOOKING.Services.UserService_1;
import com.TLCN_BOOKING.Services.countryService;
import com.TLCN_BOOKING.Services.customerService;
import com.TLCN_BOOKING.Services.roleService;
import com.TLCN_BOOKING.models.User;
import com.TLCN_BOOKING.models.Customer;
import com.TLCN_BOOKING.models.GooglePojo;
import com.TLCN_BOOKING.models.Role;

@Controller
public class LoginController {

	@Autowired
	UserService_1 userService;
//	userService userService;

	@Autowired
	customerService customerSv;

	@Autowired
	ManagerService managerSv;

	@Autowired
	countryService countrySv;

	@Autowired
	roleService roleSv;

	@Autowired
	UserDetailsServiceImpl userDetailImpl;

	// Không cho truy cập
	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/register")
	public String registerPage() {
		return "/LoginView/Register";
	}

	@Autowired
	private GoogleUtils googleUtils;

	@RequestMapping("/login-google")
	public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
		System.out.println("Bắt đầu đăng nhập bằng Google!!");
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			return "redirect:/login?google=error";
		}
		String accessToken = googleUtils.getToken(code);
		GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
		UserDetails userDetail = googleUtils.buildUser(googlePojo);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println("Đăng nhập google thành công");
		System.out.println("Tài khoản đã đăng nhập: " + googlePojo.getEmail());

		// Đã có tài khoản đăng ký thì chuyển thẳng, nếu chưa thì lưu xuống
		// db
		if (userService.findUserByUsername(userDetail.getUsername()) != null) {
			System.out.println("Tài khoản đăng nhập thành công");
			request.setAttribute("user", userService.findUserByUsername(userDetail.getUsername()));
			request.setAttribute("customer",
					customerSv.findByUser(userService.findUserByUsername(userDetail.getUsername())));
			request.setAttribute("listCountry", countrySv.findAllcountry());
			return "/CustomerView/Home";
		} else {
			System.out.println("Tài khoản chưa đăng ký");
			// Chưa đăng ký thì tự động lưu xuống db
			System.out.println("Bắt đầu lưu tài khoản google.................");
			try {// Lưu user
				System.out.println("Bắt đầu lưu tài khoản google ==> bắt đầu lưu user.................");
				User newUser = new User();
				newUser.setUsername(userDetail.getUsername());
				newUser.setEmail(userDetail.getUsername());
				newUser.setActive(1);
				newUser.setRoles((roleSv.findRoleByName("customer")));
				userService.saveUser(newUser);
				// Không lỗi và tiếp tục try để lưu thông tin customer
				try {
					System.out.println(
							"Bắt đầu lưu tài khoản google ==> bắt đầu lưu user==>customer.................");
					// Lưu Customer
					Customer newCustomer = new Customer();
					newCustomer.setUser(newUser);
					customerSv.saveCustomer(newCustomer);
				}
				// Nếu lưu không được customer thì xóa user ban đầu và thông báo lỗi
				catch (Exception e) {
					System.out
							.println("Bắt đầu lưu tài khoản google ==> Không lưu được customer.................");
					userService.delete(newUser.getId());
				}
			}
			// Lỗi lưu user
			catch (Exception e) {
				System.out.println("Bắt đầu lưu tài khoản google ==> Không lưu được user.................");
				// Lỗi lưu user
			}
			System.out.println("Tài khoản đăng ký thành công và bắt đầu đăng nhập");
			request.setAttribute("user", userService.findUserByUsername(userDetail.getUsername()));
			request.setAttribute("customer",
					customerSv.findByUser(userService.findUserByUsername(userDetail.getUsername())));

			request.setAttribute("listCountry", countrySv.findAllcountry());
			return "/CustomerView/Home";
		}
	}
	

	@RequestMapping(value = "save-regis", method = RequestMethod.GET)
	public String register(HttpServletRequest request) {
		try {// Lưu user
			System.out.println("Bắt đầu lưu tài khoản thủ công");
			User newUser = new User();
			// Kiểm tra trùng username không?
			if (userService.findUserByUsername(request.getParameter("username")) != null) {
				System.out.println("Lỗi trung username");
				return "/register";
			} else {
				System.out.println("Không trùng username==> Bắt đầu lưu user");
				newUser.setUsername(request.getParameter("username"));
				newUser.setPassword(BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt()));
				newUser.setEmail(request.getParameter("email"));
				newUser.setActive(1);
				newUser.setRoles((roleSv.findRoleByName("customer")));
				userService.saveUser(newUser);
				try {
					System.out.println(
							"Bắt đầu lưu tài khoản thủ công ==> bắt đầu lưu user==>customer.................");
					// Lưu Customer
					Customer newCustomer = new Customer();
					newCustomer.setUser(newUser);
					customerSv.saveCustomer(newCustomer);
					System.out.println("Tài khoản đăng ký thành công và đăng nhập");
					request.setAttribute("user", newUser);
					request.setAttribute("customer", newCustomer);
					request.setAttribute("listCountry", countrySv.findAllcountry());
					return "/CustomerView/Home";
				}
				// Nếu lưu không được customer thì xóa user ban đầu và thông báo lỗi
				catch (Exception e) {
					System.out.println(" ==> Không lưu được customer................." + e);
					userService.delete(newUser.getId());
					return "redirect:/register";
				}
			}
		} catch (Exception e) {
			System.out.println("==> Không lưu thành công" + e);
			return "redirect:/register";
		}

	}

	@GetMapping("/HomePage1")
	public String CustomerHomePage(HttpServletRequest request) {
		

		
		
		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		
		
		request.setAttribute("listCountry", countrySv.findAllcountry());

		return "/CustomerView/Home";
		// }
	}

	/*
	 * @PostMapping("/logining") public String getLogin(HttpServletRequest request)
	 * { User user =
	 * userService.findUserByUsername(request.getParameter("username")); String role
	 * = user.getRoles().iterator().next().getName(); request.setAttribute("user",
	 * user); if (role.equals("admin")) {
	 * System.out.println("Tên người đăng nhập: " +
	 * managerSv.findByUser(user).getName()); System.out.
	 * println("Role đăng nhập:  Adminnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
	 * request.setAttribute("profile", managerSv.findByUser(user));
	 * request.setAttribute("listUsers", userService.findAllUser()); return
	 * "/AdminView/ManagementUsers"; }
	 * 
	 * else if (role.equals("customer")) {
	 * 
	 * System.out.println("Tên người đăng nhập: " +
	 * customerSv.findByUser(user).getName());
	 * System.out.println("Đăng nhập Role:     Customermmmmmmmmmmmm");
	 * request.setAttribute("customer", customerSv.findByUser(user));
	 * request.setAttribute("listCountry", countrySv.findAllcountry()); return
	 * "/CustomerView/Home"; }
	 * 
	 * else return "/login"; // return "AdminView/ManagementCustomer"; }
	 */

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}

}
