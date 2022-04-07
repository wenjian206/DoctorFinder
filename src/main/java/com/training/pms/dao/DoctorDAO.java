package com.training.pms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.pms.model.Doctor;

@Repository
public interface DoctorDAO extends CrudRepository<Doctor, Integer>{
	List<Doctor> findDoctorBySpecialty(String specialty);
	List<Doctor> findDoctorByName(String name);
	//List<Doctor> findAllPatientsAssigned();
}