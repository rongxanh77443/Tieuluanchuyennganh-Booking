package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.ManagerRepository;
import com.TLCN_BOOKING.models.Manager;
import com.TLCN_BOOKING.models.User;

@Service
public class ManagerService {
	@Autowired
	public ManagerRepository managerRepository;
	
	public void saveManager(Manager customer) {
		// TODO Auto-generated method stub
		managerRepository.save(customer);
	}

	public Manager findByUser(User user) {
		// TODO Auto-generated method stub
		return managerRepository.findByUser(user);
	}

	public Collection<Manager> findAllManager(){
		
		List<Manager> managers= new ArrayList<Manager>();
		for (Manager manager: managerRepository.findAll())
		{
			managers.add(manager);
		}		
		return managers;
	}

	public Manager findById(int id) {
		return managerRepository.findById(id);
	};

	public void delete(int id) {
		// TODO Auto-generated method stub
		managerRepository.deleteById(id);
	}
}
