package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.dao.DoctorDAO;
import com.training.pms.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorDAO doctorDAO;
	
	@Override
	public String addDoctor(Doctor doctor) {
		if(doctor.getName() == null || doctor.getSpecialty() == null) {
			return "Please Enter A Doctor Id / Name / Specialty";
		}else {
			doctorDAO.save(doctor);
			return "Welcome Doctor";
		}
	}

	@Override
	public String updateDoctor(int doctorid, Doctor doctor) {
		if(doctor.getDoctorid() <= 0 || doctor.getName() == null || doctor.getSpecialty() == null) {
			return "Please Enter A Doctor Id / Name / Specialty";
		}else {
			doctorDAO.save(doctor);
			return "Welcome Doctor";
		}
	}

	@Override
	public String deleteDoctor(int doctorid) {
		doctorDAO.deleteById(doctorid);
		return "Doctor Information Deleted Successfully";
	}

	@Override
	public List<Doctor> getDoctors() {
		return (List<Doctor>) doctorDAO.findAll();
	}

	@Override
	public Doctor getDoctor(int doctorid) {
		Optional<Doctor> doctor = doctorDAO.findById(doctorid);
		return doctor.get();
	}

	@Override
	public boolean doesDoctorExist(int doctorid) {
		Optional<Doctor> doctor = doctorDAO.findById(doctorid);
		return doctor.isPresent();
	}

	@Override
	public boolean deleteDoctor() {
		doctorDAO.deleteAll();
		return true;
	}
	
	/*
	//May Be Error Here
	@Override
	public List<Doctor> patientsAssigned(String patients) {
		return doctorDAO.findAllPatientsAssigned();
	}
	*/
	
	@Override
	public List<Doctor> getDoctorByName(String doctorname) {
		return doctorDAO.findDoctorByName(doctorname);
	}

	@Override
	//@Transactional
	public List<Doctor> getDoctorBySpecialty(String specialty) {
		return doctorDAO.findDoctorBySpecialty(specialty);
	}

}