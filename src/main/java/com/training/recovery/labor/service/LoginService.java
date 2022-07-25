package com.training.recovery.labor.service;

import com.training.recovery.labor.model.User;

public interface LoginService {
	
	public User getUserRole(String username,String password);

}
