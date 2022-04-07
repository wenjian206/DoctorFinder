package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Doctor;

public interface DoctorService {

	public String addDoctor(Doctor doctor);
	public String updateDoctor(int doctorid,Doctor doctor);
	public String deleteDoctor(int doctorid);
	public List<Doctor> getDoctors();
	public Doctor getDoctor(int doctorid);
	public boolean doesDoctorExist(int doctorid);
	public boolean deleteDoctor();
	
	//public List<Doctor> patientsAssigned(String patients);
	public List<Doctor> getDoctorByName(String doctorname);
	public List<Doctor> getDoctorBySpecialty(String specialty);
	// approveRejectAppointment
}