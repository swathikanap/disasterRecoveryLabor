package com.training.recovery.labor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.recovery.labor.model.User;
import com.training.recovery.labor.repo.LoginRepository;
import com.training.recovery.labor.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private final LoginRepository loginRepo;

	@Autowired
	public LoginServiceImpl(final LoginRepository loginRepo) {
		this.loginRepo = loginRepo;
	}

	@Override
	public User getUserRole(String username, String passsword) {
		
		return this.loginRepo.findUserByUsernameAndPassword(username, passsword);
	}

}
