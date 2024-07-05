package com.app.pay.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.pay.dto.CustomerOrder;
import com.app.pay.repo.CustomerRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class customerService {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.secret.key}")
	private String razorPaySecretKey;
	
	private RazorpayClient client;
	
	public CustomerOrder addOrder(CustomerOrder custorder) throws RazorpayException {
		
		JSONObject orderReq= new JSONObject();
		// amount is in paisa so multilplied with 100
		orderReq.put("amount",custorder.getAmount()*100);
		orderReq.put("currency", "INR");
		orderReq.put("Reciept", custorder.getEmailId());
		
		this.client= new RazorpayClient(razorPayKey, razorPaySecretKey);
		
		//create order in razorpay
		Order razorPayOrder=client.orders.create(orderReq);
		System.out.println("RazorPayOrder -- "+razorPayOrder);
		
		custorder.setRazorPayId(razorPayOrder.get("id"));
		custorder.setOrderStatus(razorPayOrder.get("status"));
		
		custRepo.save(custorder);
		
		return custorder;
		
	}

}
