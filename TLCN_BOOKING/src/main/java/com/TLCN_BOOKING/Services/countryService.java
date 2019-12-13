package com.TLCN_BOOKING.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TLCN_BOOKING.DAO.countryRepository;
import com.TLCN_BOOKING.models.Country;

@Service
public class countryService {
	
	@Autowired
	public countryRepository countryRepository;
	
	public void savecountry(Country country) {
		// TODO Auto-generated method stub
		countryRepository.save(country);
	}
	
	public Collection<Country> findAllcountry(){
		
		List<Country> countrys= new ArrayList<Country>();
		for (Country country: countryRepository.findAll())
		{
			countrys.add(country);
		}		
		return countrys;
	}
}
