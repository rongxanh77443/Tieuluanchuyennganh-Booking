package com.TLCN_BOOKING.models;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;


@Entity(name="bills")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cusid")
	private Customer customer;
	
	@Column(name="bookingdate")
	private String bookingdate;
	
	@Column(name="status")
	private int status;
	
	@Column(name="totalprice")
	private int totalprice;
	
	public Bill() {
		
	}

	public Bill(Customer customer, String bookingdate, int status, int totalprice) {
		super();
		this.customer = customer;
		this.bookingdate = bookingdate;
		this.status = status;
		this.totalprice = totalprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}



	
	
	
	
}
