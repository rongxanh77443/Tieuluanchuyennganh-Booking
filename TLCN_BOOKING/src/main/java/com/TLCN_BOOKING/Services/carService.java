package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.carRepository;
import com.TLCN_BOOKING.models.Car;
import com.TLCN_BOOKING.models.User;

@Service
public class carService {

	@Autowired
	public carRepository carRepository;

	public void saveCar(Car car) {
		// TODO Auto-generated method stub
		carRepository.save(car);
	}

	public Collection<Car> findAllCar() {

		List<Car> cars = new ArrayList<Car>();
		for (Car car : carRepository.findAll()) {
			cars.add(car);
		}
		return cars;
	}

	public Car findById(int id) {
		return carRepository.findById(id);
	}

	public void delete(int deleteid) {
		// TODO Auto-generated method stub
		carRepository.deleteById(deleteid);
	}
}
