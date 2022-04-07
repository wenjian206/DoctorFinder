package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Bill;

public interface BillService {
	public List<Bill> getBills();
	
	public String addBill(Bill bill);

	public boolean isBillExists(int billid);
}
