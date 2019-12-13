package com.TLCN_BOOKING.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="profilecustomers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dateofbirth")	
	private  String dateofbirth;
	
	@Column(name="gender")	
	private String gender;
	
	@Column(name="phonenumber")	
	private String phonenumber;

	@Column(name="showprofile")	
	private Integer showprofile;
	
	@Column(name="country")	
	private String country;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;
	
	
	public Customer() {
		
	}

	public Customer(String name, String dateofbirth, String gender, String phonenumber, Integer showprofile,
			String country, User user) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.showprofile = showprofile;
		this.country = country;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Integer getShowprofile() {
		return showprofile;
	}

	public void setShowprofile(Integer showprofile) {
		this.showprofile = showprofile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	

	

	
	







}
