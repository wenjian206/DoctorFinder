package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Doctor;
import com.training.pms.model.Login;
import com.training.pms.model.Patient;

public interface LoginService {
	
	public String validatePatient(String username, String password);
	public String registerPatient(Patient patient);
	public String registerPatient(Login login);
	//public String registerPatient(RegistrationRequest request);
	
	public String validateDoctor(String username, String password);
	public String registerDoctor(Doctor doctor);
	
	public boolean isLoginExists(int loginId);
	
	public boolean isLoginExists(String username);
	
	public List<Login> getLogins();
	public Login getLogin(int loginid);
	// delete all logins
	public String deleteLogins();
	
	// add login (not full patient or doctor)
	public String addLogin(Login login);
	
	
}
