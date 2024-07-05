package com.app.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pay.dto.CustomerOrder;
import com.app.pay.service.customerService;
import com.razorpay.RazorpayException;

@Controller
public class CustomerController {
	
	@Autowired
	private customerService custservice;
	
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	@PostMapping(value="/create-order", produces="application/json")
	@ResponseBody
	public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder order) throws Exception{
		CustomerOrder createdOrder= custservice.addOrder(order);
		return new ResponseEntity<CustomerOrder>(createdOrder, HttpStatus.CREATED);
	}
	
	
	
	

}
