package com.TLCN_BOOKING.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Country;

@Repository
public interface countryRepository  extends CrudRepository<Country, Integer>{

}
