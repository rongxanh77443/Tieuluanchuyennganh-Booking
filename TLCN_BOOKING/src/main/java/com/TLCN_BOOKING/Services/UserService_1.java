package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.TLCN_BOOKING.models.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.TLCN_BOOKING.DAO.userRepository;
import com.TLCN_BOOKING.models.User;

@Service
public class UserService_1 {

	@Autowired
	userRepository userRepository;

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public User findById(int Id) {
		return userRepository.findById(Id);
	}

	public Role findRolesByUsername(String username) {
		return userRepository.findRolesByUsername(username);
	}

	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	public void delete(int usersid) {
		// TODO Auto-generated method stub
		userRepository.deleteById(usersid);
	}

	public Collection<User> findAllUser() {

		List<User> users = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			users.add(user);
		}
		return users;

	}
	{
	try
	{
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
		} else {
			String username = principal.toString();
		}
	}
	catch (Exception e)
	{
		
	}
	}
	
}
