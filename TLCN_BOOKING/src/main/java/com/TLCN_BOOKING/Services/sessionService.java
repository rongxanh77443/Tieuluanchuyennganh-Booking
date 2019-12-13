package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.routeRepository;
import com.TLCN_BOOKING.DAO.sessionRepository;
import com.TLCN_BOOKING.models.Car;
import com.TLCN_BOOKING.models.Route;
import com.TLCN_BOOKING.models.Session;

@Service
public class sessionService {

	@Autowired
	public sessionRepository sessionRepository;
	
	public void saveSession(Session session) {
		// TODO Auto-generated method stub
		sessionRepository.save(session);
	}
	

	public void delete(int id) {
		// TODO Auto-generated method stub
		sessionRepository.deleteById(id);
	}

	public Collection<Session> findByCar(Car car) {
		// TODO Auto-generated method stub
		return sessionRepository.findAllByCar(car);
	}

	public Collection<Session> findAllByRoute(Route route) {
		// TODO Auto-generated method stub
		List<Session> sessions= new ArrayList<Session>();
		for (Session session: sessionRepository.findAllByRoute(route))
		{
			sessions.add(session);
		}		
		return sessions;
	}


	public void delete(Session session) {
		// TODO Auto-generated method stub
		sessionRepository.delete(session);;
	}


}
