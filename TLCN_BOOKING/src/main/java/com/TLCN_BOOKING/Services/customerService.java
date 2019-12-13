package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TLCN_BOOKING.DAO.customerRepository;
import com.TLCN_BOOKING.DAO.userRepository;
import com.TLCN_BOOKING.models.Customer;
import com.TLCN_BOOKING.models.User;


@Service
public class customerService {
	
	@Autowired
	customerRepository customerRepository;
	
	@Autowired
	userRepository userRepository;
	
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}



	public Customer findByUser(User user) {
		// TODO Auto-generated method stub
		return customerRepository.findByUser(user);
	}
	public Customer findById(int id) {
		return customerRepository.findById(id);
	}
	
	public Collection<Customer> findAllCustomer() {
		// TODO Auto-generated method stub

		List<Customer> customers=new ArrayList<Customer>();

		for (Customer customer: customerRepository.findAll())
		{
			customers.add(customer);
		}
		return customers;
	}



}
