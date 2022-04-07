package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.pms.dao.PatientDAO;
import com.training.pms.model.Patient;

import lombok.AllArgsConstructor;


@Service		//spring will create a bean and treats this as service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

	@Autowired
	private final PatientDAO patientDao;
	
	@Override
	@Transactional
	public String addPatient(Patient patient) {
		if(patient.getEmail().length() < 0  || patient.getPassword().length() < 0)
			return "Patient could not be saved";
		else
		{
			patientDao.save(patient);
			return "Patient saved successfully!!";

		}
	}
	@Override
	@Transactional
	public String updatePatient(int patientId, Patient patient) {
		if(patient.getEmail().length() < 0  || patient.getPassword().length() < 0)
			return "Product could not be updated because either price or qoh is negative";
		else
		{
			patientDao.save(patient);
			return "Product updated successfully!!";

		}
	}
	@Override
	public String deletePatient(int patientId) {
		 patientDao.deleteById(patientId);
		 return "Patient deleted successfully!!";
	}

	@Override
	public List<Patient> getPatients() {
		return (List<Patient>) patientDao.findAll();
	}

	@Override
	public Patient getPatient(int patientId) {
		Optional<Patient> patient =  patientDao.findById(patientId);
		return patient.get();
	}

	@Override
	public boolean isPatientExists(int patientId) {
		Optional<Patient> product =  patientDao.findById(patientId);
		return product.isPresent();
	}

	@Override
	public String deletePatient() {
		patientDao.deleteAll();
		return "Product deleted successfully!!";
	}

	
	public List<Patient> getPatientByName(String name) {
	// TODO Auto-generated method stub
	return patientDao.findByName(name);
	}

	@Override
	public List<Patient> getPatientByBillAmountRange(int lowerAmount, int upperAmount) {
	// TODO Auto-generated method stub
	return patientDao.findByBillAmountBetween(lowerAmount, upperAmount);
	}
	@Override
	public List<Patient> getPatientByDoctorAssigned(String doctorAssigned) {
		return (List<Patient>) patientDao.findByDoctorAssigned(doctorAssigned);
	}
	
	

}
