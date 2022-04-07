package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Patient;

public interface PatientService {
	public String addPatient(Patient patient);
	public String updatePatient(int patientId, Patient patient);
	public List<Patient> getPatients();
	public Patient getPatient(int patientId);
	public boolean isPatientExists(int patientId);
	public String deletePatient();
	public String deletePatient(int patientId);
	
	public List<Patient> getPatientByName(String name);
	public List<Patient> getPatientByBillAmountRange(int lowerAmount, int upperAmount);
	public List<Patient> getPatientByDoctorAssigned(String doctorAssigned);
	
}