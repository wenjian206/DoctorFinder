package com.training.pms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
public class Appointment {
	
	@SequenceGenerator(
            name = "appointment_sequence",
            sequenceName = "appointment_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_sequence"
    )
	private int appointmentid;
	private Date date;
	private String symptom;
	private int patientid;
	private int doctorid;
	private Boolean status = false;
	
	public Appointment(Date date, String symptom, int patientid, int doctorid) {
		this.date = date;
		this.symptom = symptom;
		this.patientid = patientid;
		this.doctorid = doctorid;
	}

	public Appointment(Date date, String symptom) {
		this.date = date;
		this.symptom = symptom;
	}

	public Appointment(Date date, String symptom, int patientid) {
		this.date = date;
		this.symptom = symptom;
		this.patientid = patientid;
	}
	
	
	
	
	
}
