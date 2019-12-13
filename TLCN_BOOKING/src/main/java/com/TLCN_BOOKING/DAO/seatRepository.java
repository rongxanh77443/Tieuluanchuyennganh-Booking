package com.TLCN_BOOKING.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Car;
import com.TLCN_BOOKING.models.Seat;

@Repository
public interface seatRepository extends CrudRepository<Seat, Integer>{

	Seat findByName(int i);



	Seat findByNameAndCar(int i, Car findById);

}
