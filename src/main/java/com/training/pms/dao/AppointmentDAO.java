package com.training.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.pms.model.Appointment;

@Repository
public interface AppointmentDAO extends CrudRepository<Appointment, Integer>{

}
