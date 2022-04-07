package com.training.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.dao.BillDAO;
import com.training.pms.model.Bill;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	BillDAO billDAO;

	@Override
	public List<Bill> getBills() {
		return (List<Bill>) billDAO.findAll();
	}

	@Override
	public String addBill(Bill bill) {
		billDAO.save(bill);
		return "it works for bills";
	}

	@Override
	public boolean isBillExists(int billid) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//getBillByPatientid

}
