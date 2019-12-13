package com.TLCN_BOOKING.DAO;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Bill;
import com.TLCN_BOOKING.models.Customer;

@Repository
public interface billRepository extends CrudRepository<Bill, Integer>{

	Bill findByCustomer(Customer findByUser);

	Collection<Bill> findAllByCustomer(Customer findByUser);

}
