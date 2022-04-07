package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Login;
import com.training.pms.model.Patient;
import com.training.pms.service.PatientService;

@RestController
@RequestMapping("patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping()
	public ResponseEntity<List<Patient>> getPatients() {    //localhost:5050/patient   -GET
		ResponseEntity<List<Patient>> responseEntity = null;
		List<Patient> result = null;
		if (patientService.getPatients().equals(null)) {
			responseEntity = new ResponseEntity<List<Patient>>(result,HttpStatus.NO_CONTENT);
		} else {
			result = patientService.getPatients();
			responseEntity = new ResponseEntity<List<Patient>>(result,HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("{patientid}")
	public ResponseEntity<Patient> getPatient(@PathVariable("patientid")int patientid) {    //localhost:5050/patient/1090   -GET
		ResponseEntity<Patient> responseEntity = null;
	     Patient patient = new Patient();
	     if (patientService.isPatientExists(patientid)){
	    	 patient = patientService.getPatient(patientid);
	         responseEntity = new ResponseEntity<Patient>(patient, HttpStatus.OK);
	     }else {
	         responseEntity = new ResponseEntity<Patient>(patient , HttpStatus.NO_CONTENT);
	     }
	     return responseEntity;
	}

	@PutMapping("{patientid}")
	public ResponseEntity<String> updatePatient(@PathVariable("patientid")int patientid,
			@RequestBody Patient patient) {    //localhost:5050/patient/1090  -PUT
			ResponseEntity<String> responseEntity = null;
			String result = null;
			if(patientService.isPatientExists(patient.getPatientid())) {
				result = patientService.updatePatient(patientid, patient);
				responseEntity = new ResponseEntity<String>(result,HttpStatus.ALREADY_REPORTED);
			}else {
				result = "Patient with the ID of: "+patient.getPatientid()+" was not found in the system";
				responseEntity = new ResponseEntity<String>(result,HttpStatus.NOT_FOUND);
			}
			return responseEntity;
	}
  
  	@PostMapping
	public ResponseEntity<String> savePatient(@RequestBody Patient patient) {    //localhost:5050/patient  -POST 
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if(patientService.isPatientExists(patient.getPatientid())) {
			result = "Doctor with the ID of "+patient.getPatientid()+" Already In The System";;
			responseEntity = new ResponseEntity<String>(result,HttpStatus.ALREADY_REPORTED);
		}else {
			result = patientService.addPatient(patient);
			responseEntity = new ResponseEntity<String>(result,HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("{patientid}")
	public String deletePatient(@PathVariable("patientid")int patientid) {    //localhost:5050/patient/1090  -DELETE
		return "Deleting a single patient by patienttId: "+patientid;
	}
	@GetMapping("getPatientsByBillAmount/{lowerAmount}/{upperAmount}")
	public String getPatientsByBillAmount(@PathVariable("lowerAmount")int lowerAmount, @PathVariable("upperAmount")int upperAmount) {    //localhost:5050/patients/getPatientsByBillAmount/199/to/400
		return "Returning all the patients by bill amount between : "+lowerAmount+ " and "+upperAmount;
	}
	
	@GetMapping("getPatientByDoctorAssigned/{doctorAssigned}")
	public ResponseEntity<List<Patient>> getPatientByDoctorAssigned(@PathVariable("doctorAssigned")String doctorAssigned) {    //localhost:5050/patient/getPatientByDoctorAssigned/Nick
		List<Patient> result = patientService.getPatientByDoctorAssigned(doctorAssigned);
		ResponseEntity<List<Patient>> responseEntity = null;
		if (result.size() == 0) {
			responseEntity = new ResponseEntity<List<Patient>>(result,HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<List<Patient>>(result,HttpStatus.OK);
		}
		return responseEntity;
	}
	
	// search patients by doctorName
	
}