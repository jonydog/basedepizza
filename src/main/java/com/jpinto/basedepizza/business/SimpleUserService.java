package com.jpinto.basedepizza.business;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.jpinto.basedepizza.business.interfaces.UserService;
import com.jpinto.basedepizza.daos.UserDAO;
import com.jpinto.basedepizza.model.User;
import com.jpinto.basedepizza.utils.ServiceResult;


public class SimpleUserService implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(SimpleUserService.class);
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Transactional
	public ServiceResult<Boolean> registerNewUser(User user, String confirmPassword) { 
		
		logger.trace("RegisterNewUserService. Running with Name: {} and Email: {}...", user.getUsername(), user.getEmail());

		/* GARBAGE BELOW */
		
		ServiceResult<Boolean> serviceResult = new ServiceResult<Boolean>( );
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		if(userDao.save(user)!=null ) {	
			logger.warn("[Success] New User registered. With Name: {} and Email: {}", user.getUsername(), user.getEmail());

		} else {
			logger.warn("[Failure] New User was not registered. With Name: {} and {} Email:", user.getUsername(), user.getEmail());
		}
		
		serviceResult.setResult(true);
		return serviceResult;
	}
	
	
	
	public org.springframework.security.core.userdetails.User buildUserForAuthentication(User user) {

		List<SimpleGrantedAuthority> authority = new ArrayList<SimpleGrantedAuthority>();
		authority.add(new SimpleGrantedAuthority("USER"));

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authority);
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User u = this.userDao.getUserByEmail(arg0);
		
		return this.buildUserForAuthentication(u);
	}
	
	

}