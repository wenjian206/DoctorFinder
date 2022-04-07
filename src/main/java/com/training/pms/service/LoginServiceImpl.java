package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.dao.LoginDAO;
import com.training.pms.dao.PatientDAO;
import com.training.pms.model.Doctor;
import com.training.pms.model.Login;
import com.training.pms.model.Patient;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDAO;
	PatientDAO patientDAO;
	//private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public String validatePatient(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerPatient(Login login) {
		boolean loginExists = loginDAO.findById(login.getLoginid()).isPresent();
		if (loginExists) {
			throw new IllegalStateException("login id already taken");
		}
		
		//String encodedPassword = bCryptPasswordEncoder.encode(login.getPassword());
		
		login.setPassword(login.getPassword());
		
		loginDAO.save(login);
		
		return "it works";
	}
	
	@Override
	public String registerPatient(Patient patient) {
		boolean loginExists = patientDAO.findById(patient.getLoginid()).isPresent();
		if (loginExists) {
			throw new IllegalStateException("user id already taken");
		}
		
		//String encodedPassword = bCryptPasswordEncoder.encode(patient.getPassword());
		
		patient.setPassword(patient.getPassword());
		
		patientDAO.save(patient);
		
		return "it works";
	}

	@Override
	public String validateDoctor(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLoginExists(int loginId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isLoginExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String deleteLogins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Login> getLogins() {
		return (List<Login>) loginDAO.findAll();
	}

	@Override
	public String addLogin(Login login) {
		loginDAO.save(login);
		return "Login saved successfully";
	}

	@Override
	public Login getLogin(int loginid) {
		Optional<Login> login = loginDAO.findById(loginid);
		return login.get();
	}



	

}
