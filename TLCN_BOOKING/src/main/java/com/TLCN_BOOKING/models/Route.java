package com.TLCN_BOOKING.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="routes")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="startingpoint")
	private String startingpoint;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="timestarting")
	private String timestarting;
	
	@Column(name="timeexpecting")
	private String timeexpecting;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="carid")
	private Integer carid;
	
	public Route() {
		
	}

	public Route(String startingpoint, String destination, String timestarting, String timeexpecting, Integer price,
			Integer carid) {
		super();
		this.startingpoint = startingpoint;
		this.destination = destination;
		this.timestarting = timestarting;
		this.timeexpecting = timeexpecting;
		this.price = price;
		this.carid = carid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartingpoint() {
		return startingpoint;
	}

	public void setStartingpoint(String startingpoint) {
		this.startingpoint = startingpoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTimestarting() {
		return timestarting;
	}

	public void setTimestarting(String timestarting) {
		this.timestarting = timestarting;
	}

	public String getTimeexpecting() {
		return timeexpecting;
	}

	public void setTimeexpecting(String timeexpecting) {
		this.timeexpecting = timeexpecting;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCarid() {
		return carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}



	
	
	
	
}
