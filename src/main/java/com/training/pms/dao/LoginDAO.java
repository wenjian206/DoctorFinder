package com.training.pms.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.model.Login;

public interface LoginDAO extends CrudRepository<Login, Integer> {
	
	boolean findByUsername(String username);

}
