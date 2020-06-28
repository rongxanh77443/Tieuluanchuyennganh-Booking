//package com.TLCN_BOOKING.Services;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.TLCN_BOOKING.DAO.userRepository;
//import com.TLCN_BOOKING.models.User;
//
//@Service
//public class userService implements UserDetailsService{
//	
//	@Autowired
//	userRepository userRepository;
//
//	
//	
//
//	public void saveUser(User user) {
//		// TODO Auto-generated method stub
//		userRepository.save(user);
//	}
//	
//	public User findByUsernameAndPassword(String username, String password) {
//		return userRepository.findByUsernameAndPassword(username, password);
//	}
//	public Collection<User> findAllUser(){
//		
//		List<User> users= new ArrayList<User>();
//		for (User user: userRepository.findAll())
//		{
//			users.add(user);
//		}		
//		return users;
//	}
//	public User findById(int Id) {
//		return userRepository.findById(Id);
//	}
//
//	public void delete(int usersid) {
//		// TODO Auto-generated method stub
//		userRepository.deleteById(usersid);
//	}
//
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		 User user = userRepository.findByUsername(username);
//	        if (user == null) {
//	            throw new UsernameNotFoundException("User not found");
//	        }
//
//	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//	        Set<com.TLCN_BOOKING.models.Role> roles = user.getRoles();
//	        for (com.TLCN_BOOKING.models.Role role : roles) {
//	            grantedAuthorities.add((GrantedAuthority) new SimpleGrantedAuthority(role.getName()));
//	        }
//
//	        return new org.springframework.security.core.userdetails.User(
//	                user.getEmail(), user.getPassword(), grantedAuthorities);
//	}
//}
