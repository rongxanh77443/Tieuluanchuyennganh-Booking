package com.TLCN_BOOKING.DAO;



import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Customer;
import com.TLCN_BOOKING.models.User;




@Repository
public interface customerRepository extends CrudRepository<Customer, Integer> {
	

	public Collection<Customer> findAll();
	public Customer findById(int id);
	public Customer findByUser(User user);

}
