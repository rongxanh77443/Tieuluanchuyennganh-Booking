package com.TLCN_BOOKING.DAO;



import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.User;




@Repository
public interface userRepository extends CrudRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);
	public User findById(int id);
	public Collection<User> findAll();

}
