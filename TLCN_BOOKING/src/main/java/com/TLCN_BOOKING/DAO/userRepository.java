package com.TLCN_BOOKING.DAO;



import java.util.Collection;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TLCN_BOOKING.models.User;
import com.TLCN_BOOKING.models.Role;

@Repository
public interface userRepository extends CrudRepository<User, Integer> {
	
	public User findByUsernameAndPassword(String username, String password);
	public User findById(int id);
	public Collection<User> findAll();
	public User findByUsername(String username);
	public User findUserByUsername(String username);
	public Role findRolesByUsername(String username);
}
