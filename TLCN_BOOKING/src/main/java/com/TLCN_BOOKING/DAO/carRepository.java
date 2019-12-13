package com.TLCN_BOOKING.DAO;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Car;
import com.TLCN_BOOKING.models.Route;

@Repository
public interface carRepository extends CrudRepository<Car, Integer>{

	public Collection<Car> findAll();
	public Car findById(int id);
}
