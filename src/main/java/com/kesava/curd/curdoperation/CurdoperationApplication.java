package com.kesava.curd.curdoperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kesava.curd.curdoperation.model.Customer;
import com.kesava.curd.curdoperation.service.CurdService;

@SpringBootApplication
public class CurdoperationApplication {
	
	@Autowired
	private CurdService curdService;

	public static void main(String[] args) {
		SpringApplication.run(CurdoperationApplication.class, args);
		
	}
	
	public void run(String... args) {
		Customer customer = new Customer();
		customer.setName("kesava");
		customer.setEmail("kesava@gmail.com");
		customer.setPhone("8801384532");
		customer.setCurrentbalance(25000);
		curdService.saveCustomer(customer);
	}

}
