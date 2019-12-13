package com.TLCN_BOOKING.models;


import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="seatid")
	private int seatid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="billid")
	private Bill bill;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sessionid")
	private Session session;
	
	public Ticket() {
		
	}

	public Ticket(int seat, Bill bill, String status, Session session) {
		super();
		this.seatid = seat;
		this.bill = bill;
		this.status = status;
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeat() {
		return seatid;
	}

	public void setSeat(int seat) {
		this.seatid = seat;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	

	

	
	
	
}
