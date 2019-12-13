package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.routeRepository;
import com.TLCN_BOOKING.models.Route;

@Service
public class routeService {
	
	@Autowired
	public routeRepository routeRepository;
	
	public void saveRoute(Route route) {
		// TODO Auto-generated method stub
		routeRepository.save(route);
	}
	
	public Collection<Route> findAllRoute(){
		
		List<Route> Routes= new ArrayList<Route>();
		for (Route Route: routeRepository.findAll())
		{
			Routes.add(Route);
		}		
		return Routes;
	}

	public Collection<Route> findAllByStrAndDes(String str, String des) {
		List<Route> Routes= new ArrayList<Route>();
		for (Route Route: routeRepository.findAllByStartingpointAndDestination(str, des))
		{
			Routes.add(Route);
		}		
		return Routes;
	}

	public void delete(int deleteid) {
		// TODO Auto-generated method stub
		routeRepository.deleteById(deleteid);
	}

	public Route findById(int id) {
		// TODO Auto-generated method stub
		return routeRepository.findById(id);
	}
}
