package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.seatRepository;
import com.TLCN_BOOKING.models.Car;
import com.TLCN_BOOKING.models.Seat;

@Service
public class seatService {

	@Autowired
	public seatRepository seatRepository;
	
	public void saveSeat(Seat seat) {
		// TODO Auto-generated method stub
		seatRepository.save(seat);
	}
	
	public Collection<Seat> findAllSeat(){
		
		List<Seat> seats= new ArrayList<Seat>();
		for (Seat seat: seatRepository.findAll())
		{
			seats.add(seat);
		}		
		return seats;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		seatRepository.deleteById(id);
	}

	public Seat findByName(int i) {
		// TODO Auto-generated method stub
		return seatRepository.findByName(i);
	}




	public Seat findByNameAndCar(int i, Car findById) {
		return seatRepository.findByNameAndCar(i, findById);
	}
}
