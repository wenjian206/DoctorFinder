package com.training.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {
	
	@SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
	private int patientid;
	
	private String name;
	private String email;
	private String password;
	private String city;
	private String symptom;
	private String doctorAssigned;
	private int billAmount;
	private int loginid;
	private int doctorid;
	//private Boolean locked = false;
	//private Boolean enabled = true;
	
	
	public Patient(String name, String email, String password, String city, String symptom, String doctorAssigned,
			int billAmount, int loginId, Boolean locked, Boolean enabled) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.symptom = symptom;
		this.doctorAssigned = doctorAssigned;
		this.billAmount = billAmount;
		this.loginid = loginId;
	}
	public Patient(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Patient(int patientid, String name, String email, String password, String city, String symptom) {
		this.patientid = patientid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.symptom = symptom;
	}
	public Patient(String name, String email, String password, String city, String symptom, String doctorAssigned) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.symptom = symptom;
		this.doctorAssigned = doctorAssigned;
	}
	public Patient(String name, String email, String password, String city, int billAmount, int loginId) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.billAmount = billAmount;
		this.loginid = loginId;
	}
	public Patient(String name, String email, String password, String city, String symptom, String doctorAssigned,
			int billAmount, int doctorid) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.symptom = symptom;
		this.doctorAssigned = doctorAssigned;
		this.billAmount = billAmount;
		this.doctorid = doctorid;
	}
	
	
	
	
	
	
	
}