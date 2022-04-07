package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Login;
import com.training.pms.service.LoginService;
import com.training.pms.service.LoginServiceImpl;

@RestController
@RequestMapping("login")
@CrossOrigin(origins ="http://localhost:4200")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	LoginServiceImpl loginServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<Login>> getLogins() {			//localhost:5050/login		-GET
		ResponseEntity<List<Login>> responseEntity = null;
		List<Login> result = null;
		if(loginService.getLogins().equals(null)) {
			result = loginService.getLogins();
			responseEntity = new ResponseEntity<List<Login>>(result, HttpStatus.NO_CONTENT);
		} else {
			result = loginService.getLogins();
			responseEntity = new ResponseEntity<List<Login>>(result, HttpStatus.OK);
		}
		return responseEntity;
		// return "Getting all the logins";
	}
	
	
	// Get one login by id
	@GetMapping("{loginid}")
	public ResponseEntity<Login> getLogin(@PathVariable("loginid")int loginid) 		//localhost:5050/login/single		-GET
	{		
		ResponseEntity<Login> responseEntity = null;
		Login login = new Login();
		if (loginService.isLoginExists(loginid)) 
		{
			login = loginService.getLogin(loginid);
			responseEntity = new ResponseEntity<Login>(login, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Login>(login, HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<String> saveLogin(@RequestBody Login login) {			//localhost:5050/login			-POST
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (loginService.isLoginExists(login.getLoginid())) {
			result = "Login with login id :" + login.getLoginid() + " already exists";
			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			result = loginService.addLogin(login);
			responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);
		}
		return responseEntity;
	}
	/*
	@PostMapping
	public String register(@RequestBody RegistrationRequest request) {
		return loginService.registerPatient(request);
	}
	*/
	
}
