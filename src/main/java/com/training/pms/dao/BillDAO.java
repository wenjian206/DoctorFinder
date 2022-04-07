package com.training.pms.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.model.Bill;

public interface BillDAO extends CrudRepository<Bill, Integer> {

}
