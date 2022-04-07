package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Appointment;

public interface AppointmentService {
	
	public List<Appointment> getAppointments();
	public String addAppointment(Appointment appointment);
	public boolean isAppointmentExists(int appointmentid);
	public String deleteAppointment(int appointmentid);

}
