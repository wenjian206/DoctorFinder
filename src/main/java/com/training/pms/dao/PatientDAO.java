package com.training.pms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.pms.model.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Integer> {
	List<Patient>  findByBillAmountBetween(int lowerAmount,int upperAmount);
	List<Patient> findByName(String name);
	List<Patient>  findByDoctorAssigned(String doctorAssigned);

}