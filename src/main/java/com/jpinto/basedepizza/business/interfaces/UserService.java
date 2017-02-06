package com.jpinto.basedepizza.business.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jpinto.basedepizza.model.User;
import com.jpinto.basedepizza.utils.ServiceResult;

public interface UserService extends  UserDetailsService  {

	
	public ServiceResult<Boolean> registerNewUser(User user, String confirmPassword);
	
}
