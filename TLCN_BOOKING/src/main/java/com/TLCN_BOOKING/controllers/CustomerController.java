package com.TLCN_BOOKING.controllers;

import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TLCN_BOOKING.Services.billService;
import com.TLCN_BOOKING.Services.carService;
import com.TLCN_BOOKING.Services.countryService;
import com.TLCN_BOOKING.Services.customerService;
import com.TLCN_BOOKING.Services.routeService;
import com.TLCN_BOOKING.Services.seatService;
import com.TLCN_BOOKING.Services.sessionService;
import com.TLCN_BOOKING.Services.ticketService;
import com.TLCN_BOOKING.Services.userService;
import com.TLCN_BOOKING.models.Bill;
import com.TLCN_BOOKING.models.Customer;
import com.TLCN_BOOKING.models.Route;
import com.TLCN_BOOKING.models.Seat;
import com.TLCN_BOOKING.models.Session;
import com.TLCN_BOOKING.models.Ticket;
import com.TLCN_BOOKING.models.User;

@Controller
public class CustomerController {

	static List<String> showseats = new ArrayList<String>();
	static List<Integer> intshowseats = new ArrayList<Integer>();
	static List<Seat> saveshowseats = new ArrayList<Seat>();

	@Autowired
	routeService routeSv;

	@Autowired
	userService userSv;

	@Autowired
	billService billSv;

	@Autowired
	ticketService ticketSv;

	@Autowired
	carService carSv;

	@Autowired
	seatService seatSv;

	@Autowired
	sessionService sessionSv;

	@Autowired
	countryService countrySv;

	@Autowired
	customerService customerSv;

	@PostMapping("/FindRoute")
	public String findroute(@RequestParam("userid") String userid, @RequestParam String str, @RequestParam String des,
			@RequestParam("departDate") String date, HttpServletRequest request) {

		System.out.println("Buoc 2: Chon Route");

		request.setAttribute("user", userSv.findById(Integer.parseInt(userid)));

		System.out.println("Diem bat da chon: " + str);
		System.out.println("Diem don da chon: " + des);

		request.setAttribute("listroute", routeSv.findAllByStrAndDes(str, des));

		System.out.println("Tong so route chon duoc: " + routeSv.findAllByStrAndDes(str, des).size());

		request.setAttribute("datestart", date);

		return "CustomerView/ChooseRoute";
	}

	@PostMapping("/addroute")
	public String addroute(@RequestParam("userid") String userid, @RequestParam("departDate") String date,
			@RequestParam("idroute") int idroute, HttpServletRequest request) {
		request.setAttribute("user", userSv.findById(Integer.parseInt(userid)));
		System.out.println("Buoc 3: Chon Seat");
		Route routechoosed = routeSv.findById(idroute);
		request.setAttribute("route", routechoosed);
		request.setAttribute("datestart", date);
		return "/CustomerView/ChooseSeat";
	}

	@PostMapping("/confirm")
	public String confirm(@RequestParam("userid") String userid, @RequestParam("departDate") String date,
			@RequestParam("idroute") int idroute, @RequestParam("totalseat") String totalseat,
			@RequestParam("s1") String seat1, @RequestParam("s2") String seat2, @RequestParam("s3") String seat3,
			@RequestParam("s4") String seat4, @RequestParam("s5") String seat5, @RequestParam("s6") String seat6,
			@RequestParam("s7") String seat7, @RequestParam("s8") String seat8, @RequestParam("s9") String seat9,
			@RequestParam("s10") String seat10, @RequestParam("s11") String seat11, @RequestParam("s12") String seat12,
			HttpServletRequest request) {
		request.setAttribute("user", userSv.findById(Integer.parseInt(userid)));
		request.setAttribute("profile", customerSv.findByUser(userSv.findById(Integer.parseInt(userid))));
		System.out.println("Buoc 4: Confirm");
		Route routechoosed = routeSv.findById(idroute);
		request.setAttribute("route", routechoosed);
		System.out.println("Tong ghe da chon: " + totalseat);
		int totalprice = Integer.parseInt(totalseat) * routeSv.findById(idroute).getPrice();

		if (seat1.equals("Seat1")) {
			showseats.add(seat1);
			intshowseats.add(1);

		}
		if (seat2.equals("Seat2")) {
			showseats.add(seat2);
			intshowseats.add(2);

		}
		if (seat3.equals("Seat3")) {
			showseats.add(seat3);
			intshowseats.add(3);

		}
		if (seat4.equals("Seat4")) {
			showseats.add(seat4);
			intshowseats.add(4);
		}
		if (seat5.equals("Seat5")) {
			showseats.add(seat5);
			intshowseats.add(5);
		}
		if (seat6.equals("Seat6")) {
			showseats.add(seat6);
			intshowseats.add(6);
		}
		if (seat7.equals("Seat7")) {
			showseats.add(seat7);
			intshowseats.add(7);
		}
		if (seat8.equals("Seat8")) {
			showseats.add(seat8);
			intshowseats.add(8);
		}
		if (seat9.equals("Seat9")) {
			showseats.add(seat9);
			intshowseats.add(9);
		}
		if (seat10.equals("Seat10")) {
			showseats.add(seat10);
			intshowseats.add(10);
		}
		if (seat11.equals("Seat11")) {
			showseats.add(seat11);
			intshowseats.add(11);
		}
		if (seat12.equals("Seat12")) {
			showseats.add(seat12);
			intshowseats.add(12);
		}
		System.out.println("Check tong ghe da chon: " + showseats.size());
		request.setAttribute("showseats", showseats);

		request.setAttribute("totalprice", totalprice);
		request.setAttribute("datestart", date);

		return "/CustomerView/Confirm";
	}

	@SuppressWarnings("null")
	@PostMapping(value = "/addbill")
	public String addbill(@RequestParam("userid") String userid, @RequestParam("departDate") String departDate,
			@RequestParam("routeid") String routeid, @RequestParam("totalprice") String totalprice,
			HttpServletRequest request) {

		System.out.println("User them : " + userid);

		request.setAttribute("profile", customerSv.findByUser(userSv.findById(Integer.parseInt(userid))));
		request.setAttribute("user", userSv.findById(Integer.parseInt(userid)));
		request.setAttribute("userid", (Integer.parseInt(userid)));
		request.setAttribute("listCountry", countrySv.findAllcountry());

		Bill bill = new Bill(customerSv.findByUser(userSv.findById(Integer.parseInt(userid))),
				java.time.LocalDate.now().toString(),
				carSv.findById(routeSv.findById(Integer.parseInt(routeid)).getCarid()).getId(),
				Integer.parseInt(totalprice));
		billSv.saveBill(bill);
		Session session = new Session(carSv.findById(routeSv.findById(Integer.parseInt(routeid)).getCarid()),
				routeSv.findById(Integer.parseInt(routeid)), departDate);
		sessionSv.saveSession(session);
		for (int i = 0; i < showseats.size(); i++) {
			Ticket ticket = new Ticket(intshowseats.get(i), bill, "available", session);
			System.out.println("Ve luu la: code seat: " + ticket.getSeat() + ", code bill: " + ticket.getBill().getId()
					+ ", code session: " + ticket.getSession().getId());
			ticketSv.saveTicket(ticket);
		}

		Customer customer = customerSv.findByUser(userSv.findById(Integer.parseInt(userid)));
		Collection<Bill> bill1s = billSv.findAllByCustomer(customer);

		System.out.println(bill1s.size() + "               Size  Bill");
		List<Ticket> listtickets = new ArrayList<Ticket>();
		for (Bill bill1 : bill1s) {
			if (ticketSv.findAllTicketByBill(bill1).size() != 0)
				for (Ticket ticket : ticketSv.findAllTicketByBill(bill1)) {
					listtickets.add(ticket);
				}
		}

		request.setAttribute("listtickets", listtickets);
		return "/CustomerView/ManagementTicket";
	}

	@GetMapping(value = "/deletetickets/{userid}/{ticketid}")
	public String deleteUser(@PathVariable("userid") String userid, @PathVariable("ticketid") int ticketid,
			HttpServletRequest request) {
		request.setAttribute("user", userSv.findById(Integer.parseInt(userid)));
		request.setAttribute("userid", userid);
		Customer customer = customerSv.findByUser(userSv.findById(Integer.parseInt(userid)));
		System.out.println("Xoa ve cua khach hang: " + customer.getName());

		Collection<Bill> bills = billSv.findAllByCustomer(customer);
		List<Ticket> listtickets = new ArrayList<Ticket>();
		for (Bill bill : bills) {
			if (ticketSv.findAllTicketByBill(bill).size() != 0)
				for (Ticket ticket : ticketSv.findAllTicketByBill(bill)) {
					if (ticket.getId() == ticketid) {
						ticketSv.delete(ticketid);
					} else {
						listtickets.add(ticket);
					}
				}
		}

		request.setAttribute("listtickets", listtickets);
		return "/CustomerView/ManagementTicket";
	}
	@GetMapping(value="/Homeuser/{userid}")
	public String homeuser(@PathVariable("userid") String userid,HttpServletRequest request) {
		User user= userSv.findById(Integer.parseInt(userid));
		request.setAttribute("user", user);
		request.setAttribute("userid", userid);
		request.setAttribute("profile",
				customerSv.findByUser(userSv.findById(Integer.parseInt(userid))));
		request.setAttribute("listCountry", countrySv.findAllcountry());
		return "/CustomerView/Home";
	}
	@GetMapping("/CustomerViewManagementTicket/{userid}")
	public String managerticket(@PathVariable("userid") String userid,HttpServletRequest request) {
		User user= userSv.findById(Integer.parseInt(userid));
		request.setAttribute("userid", userid);
		request.setAttribute("user", user);
		Customer customer = customerSv.findByUser(userSv.findById(Integer.parseInt(userid)));
		Collection<Bill> bill1s = billSv.findAllByCustomer(customer);

		System.out.println(bill1s.size() + "               Size  Bill");
		List<Ticket> listtickets = new ArrayList<Ticket>();
		for (Bill bill1 : bill1s) {
			if (ticketSv.findAllTicketByBill(bill1).size() != 0)
				for (Ticket ticket : ticketSv.findAllTicketByBill(bill1)) {
					listtickets.add(ticket);
				}
		}
		
		request.setAttribute("listtickets", listtickets);
		return "/CustomerView/ManagementTicket";
	}
}
