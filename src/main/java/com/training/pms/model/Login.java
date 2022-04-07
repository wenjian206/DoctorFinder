package com.training.pms.model;

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
@Table(name = "dflogin")
public class Login {
	
	@SequenceGenerator(
            name = "login_sequence",
            sequenceName = "login_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "login_sequence"
    )
	private int loginid;
	private String username;
	private String password;
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
}
