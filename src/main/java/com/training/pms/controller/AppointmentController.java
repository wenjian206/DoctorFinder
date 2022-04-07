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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Appointment;
import com.training.pms.service.AppointmentService;

@RestController
@RequestMapping("appointment")
@CrossOrigin(origins="http://localhost:4200")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping
	public ResponseEntity<List<Appointment>> getAppointments() {			//localhost:5050/appointment		-GET
		ResponseEntity<List<Appointment>> responseEntity = null;
		List<Appointment> result = null;
		if(appointmentService.getAppointments().equals(null)) {
			result = appointmentService.getAppointments();
			responseEntity = new ResponseEntity<List<Appointment>>(result, HttpStatus.NO_CONTENT);
		} else {
			result = appointmentService.getAppointments();
			responseEntity = new ResponseEntity<List<Appointment>>(result, HttpStatus.OK);
		}
		return responseEntity;
		// return "Getting all the appointments";
	}
	
	@PostMapping
	public ResponseEntity<String> saveAppointment(@RequestBody Appointment appointment) {			//localhost:5050/appointment			-POST
		ResponseEntity<String> responseEntity = null;
		String result = null;
		
			result = appointmentService.addAppointment(appointment);
			responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("{appointmentid}")
	public ResponseEntity<String> deleteAppointment(@PathVariable("appointmentid")int appointmentid) {		//localhost:5050/product		-DELETE
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (appointmentService.isAppointmentExists(appointmentid)) {
			result = appointmentService.deleteAppointment(appointmentid);
			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			result = "Appointment with appointment id :" + appointmentid + " does not exist";
			responseEntity = new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}
