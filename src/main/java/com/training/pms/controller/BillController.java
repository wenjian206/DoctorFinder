package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Bill;
import com.training.pms.service.BillService;

@RestController
@RequestMapping("bill")
@CrossOrigin(origins = "http://localhost:4200")
public class BillController {
	
	@Autowired
	BillService billService;
	
	@GetMapping
	public ResponseEntity<List<Bill>> getBills() {			//localhost:5050/bill		-GET
		ResponseEntity<List<Bill>> responseEntity = null;
		List<Bill> result = null;
		if(billService.getBills().equals(null)) {
			result = billService.getBills();
			responseEntity = new ResponseEntity<List<Bill>>(result, HttpStatus.NO_CONTENT);
		} else {
			result = billService.getBills();
			responseEntity = new ResponseEntity<List<Bill>>(result, HttpStatus.OK);
		}
		return responseEntity;
		// return "Getting all the bills";
	}
	
	@PostMapping
	public ResponseEntity<String> saveBill(@RequestBody Bill bill) {			//localhost:5050/bill			-POST
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (billService.isBillExists(bill.getBillid())) {
			result = "Bill with bill id :" + bill.getBillid() + " already exists";
			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);
		} else {
			result = billService.addBill(bill);
			responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);
		}
		return responseEntity;
	}

}
