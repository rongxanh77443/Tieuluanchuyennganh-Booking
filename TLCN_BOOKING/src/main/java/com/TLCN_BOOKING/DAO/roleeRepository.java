package com.TLCN_BOOKING.DAO;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.TLCN_BOOKING.models.Role;
import com.TLCN_BOOKING.models.User;

public interface roleeRepository extends CrudRepository<Role, Integer> {

	public Role findByName(String name);
	public Role findById(int id);
	public Set<Role> findRoleByName(String name);
}
