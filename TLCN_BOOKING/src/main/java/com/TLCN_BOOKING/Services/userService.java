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
public class userService {
	
	@Autowired
	userRepository userRepository;


	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	public Collection<User> findAllUser(){
		
		List<User> users= new ArrayList<User>();
		for (User user: userRepository.findAll())
		{
			users.add(user);
		}		
		return users;
	}
	public User findById(int Id) {
		return userRepository.findById(Id);
	}

	public void delete(int usersid) {
		// TODO Auto-generated method stub
		userRepository.deleteById(usersid);
	}
}
