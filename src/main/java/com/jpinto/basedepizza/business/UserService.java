package com.jpinto.basedepizza.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpinto.basedepizza.daos.UserDAO;
import com.jpinto.basedepizza.model.User;
import com.jpinto.basedepizza.utils.ErrorCode;
import com.jpinto.basedepizza.utils.ServiceResult;


@Service("userService")
public class UserService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public ServiceResult<User> registerNewUser(User user, String confirmPassword) { 
		
		logger.trace("RegisterNewUserService. Running with Email: {}...",  user.getEmail());
		
		ServiceResult<User> serviceResult = new ServiceResult<User>();
		
		//error: passwords do not match
		if( ! user.getPassword().equals(confirmPassword)){
			ErrorCode errorCode = new ErrorCode(false,500,"Confirmation password does not match");
			serviceResult.setResult(user);
			serviceResult.setErrorCode(errorCode);
			logger.debug("Failed inserting user: " + errorCode);
			return serviceResult;
		}
		
		try{
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			this.userDao.save(user);
			ErrorCode errorCode = new ErrorCode(true,200,"Success when inserting user");
			serviceResult.setResult(user);
			serviceResult.setErrorCode(errorCode);
			logger.debug("Success inserting user: " + errorCode);
			return serviceResult;
		}
		catch(DataAccessException e){
			ErrorCode errorCode = new ErrorCode(false,500,"Failed to insert user in database");
			serviceResult.setResult(user);
			serviceResult.setErrorCode(errorCode);
			logger.debug("Failed inserting user: " + errorCode);
			return serviceResult;
		}
	}
	
	
	public org.springframework.security.core.userdetails.User buildUserForAuthentication(User user) {
		List<SimpleGrantedAuthority> authority = new ArrayList<SimpleGrantedAuthority>();
		authority.add(new SimpleGrantedAuthority("USER"));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authority);
	}
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User u = this.userDao.getUserByEmail(arg0);		
		return this.buildUserForAuthentication(u);
	}

}