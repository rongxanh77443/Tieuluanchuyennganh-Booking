package com.TLCN_BOOKING.DAO;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Route;
import com.TLCN_BOOKING.models.User;

@Repository
public interface routeRepository extends CrudRepository<Route, Integer>{
	

	public Collection<Route> findAll();
	public Route findById(int id);
	public Collection<Route> findAllByStartingpointAndDestination(String str, String des);
	public Collection<Route> findAllByCarid(int deleteid);

}
