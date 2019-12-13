package com.TLCN_BOOKING.DAO;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.Manager;
import com.TLCN_BOOKING.models.User;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer>{

	public Collection<Manager> findAll();

	public Manager findByUser(User user);
	public Manager findById(int id);
}
