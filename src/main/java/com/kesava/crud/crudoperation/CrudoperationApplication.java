package com.kesava.crud.crudoperation;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.kesava.crud.crudoperation.model.Customer;
import com.kesava.crud.crudoperation.service.CrudService;

@SpringBootApplication 
public class CrudoperationApplication {
	static Logger logger = Logger.getLogger(CrudoperationApplication.class);
	
 
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CrudoperationApplication.class, args);
		CrudService crudService = applicationContext.getBean("crudService",CrudService.class);
		Customer customer = new Customer();
		customer.setName("kesava");
		customer.setEmail("kesava@gmail.com");
		customer.setPhone("8801384532");
		customer.setCurrentbalance(25000);
		crudService.saveCustomer(customer);
		logger.info("inserted customer object");
	}

}
