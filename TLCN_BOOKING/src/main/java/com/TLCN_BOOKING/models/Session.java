package com.TLCN_BOOKING.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="carid")
	private Car car;
	
	@OneToOne
	@JoinColumn(name="routeid")
	private Route route;
	
	@Column(name="departdate")
	private String departdate;
	
	public Session() {
		
	}

	public Session( Car car, Route route, String departdate) {
		super();
		this.car = car;
		this.route = route;
		this.departdate = departdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getDepartdate() {
		return departdate;
	}

	public void setDepartdate(String departdate) {
		this.departdate = departdate;
	}

	
	
}
