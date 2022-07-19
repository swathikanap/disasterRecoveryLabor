package com.training.recovery.labor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.recovery.labor.model.User;
import com.training.recovery.labor.service.LoginService;

@RestController
@RequestMapping("/disaster/recovery/")
public class LoginController {

	private final LoginService loginService;

	@Autowired
	public LoginController(final LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("login")
	public ResponseEntity<User> getRole(@RequestBody User user) {

		User userDetails = this.loginService.getUserRole(user.getUsername(), user.getPassword());
		System.out.println("Role from dB: " + userDetails.getUser_role());

		return new ResponseEntity<User>(userDetails, HttpStatus.ACCEPTED);

	}

}
