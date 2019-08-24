package com.kesava.crud.crudoperation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kesava.crud.crudoperation.model.Customer;
import com.kesava.crud.crudoperation.service.CrudService;

@SpringBootApplication
public class CrudoperationApplication {
	static Logger logger = Logger.getLogger(CrudoperationApplication.class);
	
	@Autowired
	private CrudService crudService;

	public static void main(String[] args) {
		SpringApplication.run(CrudoperationApplication.class, args);
		
	}
	
	public void run(String... args) {
		Customer customer = new Customer();
		customer.setName("kesava");
		customer.setEmail("kesava@gmail.com");
		customer.setPhone("8801384532");
		customer.setCurrentbalance(25000);
		crudService.saveCustomer(customer);
		logger.debug("inserting customer object");
	}

}
