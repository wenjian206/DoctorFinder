package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.pms.model.Doctor;
import com.training.pms.service.DoctorService;

@RestController
@RequestMapping("doctor")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	//Get All Doctors
		@GetMapping()
		public ResponseEntity<List<Doctor>> getDoctors() {
			ResponseEntity<List<Doctor>> responseEntity = null;
		     List<Doctor> doctor = null;
		     if (!doctorService.getDoctors().equals(null)) {
		    	 doctor = doctorService.getDoctors();
		         responseEntity = new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);
		     }else {
		         responseEntity = new ResponseEntity<List<Doctor>>(doctor , HttpStatus.NO_CONTENT);
		     }
		     return responseEntity;
		}

	//Add Doctor To System
	@PostMapping
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if(doctorService.doesDoctorExist(doctor.getDoctorid())) {
			result = "Doctor with the ID of "+doctor.getDoctorid()+" Already In The System";
			responseEntity = new ResponseEntity<String>(result,HttpStatus.ALREADY_REPORTED);
		}else {
			result = doctorService.addDoctor(doctor);
			responseEntity = new ResponseEntity<String>(result,HttpStatus.CREATED);
		}
		return responseEntity;
	}
	//Update Doctor By ID
	@PutMapping("{doctorid}")
	public ResponseEntity<String> updateDoctor(@PathVariable("doctorid") int doctorid,@RequestBody Doctor doctor) {
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if(doctorService.doesDoctorExist(doctor.getDoctorid())) {
			result = doctorService.updateDoctor(doctorid, doctor);
			responseEntity = new ResponseEntity<String>(result,HttpStatus.OK);
		}else {
			result = "Doctor with the ID of: "+doctor.getDoctorid()+" was not found in the system";
			responseEntity = new ResponseEntity<String>(result,HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	//Delete Doctor By ID
	@DeleteMapping("{doctorid}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("doctorid")int doctorid) {
		ResponseEntity<String> responseEntity = null;
        String result = null;
        if (doctorService.doesDoctorExist(doctorid)) {
            result = doctorService.deleteDoctor(doctorid);
            responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);
        } else {
            result = "Doctor with the  id of :" + doctorid + " does not exist";
            responseEntity = new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
	}
	//Get Doctor By ID 
	@GetMapping("{doctorid}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable("doctorid")int doctorid) {
		ResponseEntity<Doctor> responseEntity = null;
	     Doctor doctor = new Doctor();
	     if (doctorService.doesDoctorExist(doctorid)){
	    	 doctor = doctorService.getDoctor(doctorid);
	         responseEntity = new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	     }else {
	         responseEntity = new ResponseEntity<Doctor>(doctor , HttpStatus.NO_CONTENT);
	     }
	     return responseEntity;
	}
	//Deletes All Doctors
	@DeleteMapping("/allDoctor")
	public String deleteDoctors() {
		return "Deleting all Doctors in system";
	}
	/*
	//Show All Patients Assigned to a doctor
	@GetMapping("{patients}")
	public ResponseEntity<List<Doctor>> patientsAssigned(@PathVariable("patients_assigned")String patients) {
		List<Doctor> result = doctorService.patientsAssigned(patients);
		ResponseEntity<List<Doctor>> responseEntity = null;
		if(result.size() == 0) {
			responseEntity = new ResponseEntity<List<Doctor>>(result,HttpStatus.NO_CONTENT);
		}else {
			responseEntity = new ResponseEntity<List<Doctor>>(result,HttpStatus.OK);
		}
		return responseEntity;
	}
	*/
	
	//Search Doctor By Name
	@GetMapping("searchDoctorByName/{doctorname}")
	public ResponseEntity<List<Doctor>>getDoctorByName(@PathVariable("doctorname")String doctorname) {
		List<Doctor> result = doctorService.getDoctorByName(doctorname);
		ResponseEntity<List<Doctor>> responseEntity = null;
		if(result.size() == 0) {
			responseEntity = new ResponseEntity<List<Doctor>>(result,HttpStatus.NO_CONTENT);
		}else {
			responseEntity = new ResponseEntity<List<Doctor>>(result,HttpStatus.OK);
		}
		return responseEntity;
	}
	//Search Doctor By Specialty
	@GetMapping("searchDoctorBySpecialty/{specialty}")
	public ResponseEntity<List<Doctor>> getDoctorBySpecailty(@PathVariable("specialty") String specialty) {
		List<Doctor> result = doctorService.getDoctorBySpecialty(specialty);
		ResponseEntity<List<Doctor>> responseEntity = null;
		if(result.size() == 0) {
			responseEntity = new ResponseEntity<List<Doctor>>(result,HttpStatus.NO_CONTENT);
		}else {
			responseEntity = new ResponseEntity<List<Doctor>>(result,HttpStatus.OK);
		}
		return responseEntity;
	}
}