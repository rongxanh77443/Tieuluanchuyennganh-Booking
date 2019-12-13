package com.TLCN_BOOKING.DAO;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Car;
import com.TLCN_BOOKING.models.Route;
import com.TLCN_BOOKING.models.Session;

@Repository
public interface sessionRepository extends CrudRepository<Session, Integer>{

	public Session findByCar(Car car);
	public Collection<Session> findAll();
	public Collection<Session> findAllByCar(Car car);
	public Collection<Session> findAllByRoute(Route route);
}
