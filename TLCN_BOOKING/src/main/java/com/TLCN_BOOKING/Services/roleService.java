package com.TLCN_BOOKING.Services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.roleeRepository;
import com.TLCN_BOOKING.models.Role;
import com.TLCN_BOOKING.models.User;

@Service
public class roleService {

	@Autowired
	roleeRepository roleRes;
	
	public Role findByName(String name) {
		return roleRes.findByName(name);
	}

	public Set<Role> findRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleRes.findRoleByName(name);
	}
	
}
