package com.kesava.crud.crudoperation.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kesava.crud.crudoperation.model.Customer;
import com.kesava.crud.crudoperation.service.CrudService;

@Controller
public class CrudController {
	static Logger logger = Logger.getLogger(CrudController.class);
 
@Autowired
private CrudService crudService;

@GetMapping(value = "/") 
public String index() { 
	return "customer";
}

@PostMapping(value = "/createcustomer")
@ResponseBody
@CrossOrigin
public void addCustomer(Customer customer) {
	crudService.saveCustomer(customer);
}

@GetMapping(value = "/getallcustomer")
@CrossOrigin
@ResponseBody
public Iterable<Customer> getAllCustomers() {
	return crudService.getAllCustomers(); 
}

@GetMapping(value = "/getcustomer/{id}")
@ResponseBody
@CrossOrigin
public Optional<Customer> getCustomer(@PathVariable("id")Integer id) {
	logger.info("calling getcustomer ....");
	return crudService.getByCustomerId(id);
}

@PutMapping(value = "/update/{id}/{currentbalance}")
@ResponseBody
@CrossOrigin
public Customer updateCustomer(@PathVariable("id") Integer id,@PathVariable("currentbalance") long currentbalance) {
	return crudService.updateCustomerBalance(id,currentbalance);
}

@DeleteMapping(value = "/delete/{id}")
@CrossOrigin
@ResponseBody
public void deleteCustomer(@PathVariable("id") Integer id) {
	crudService.deleteByCustomer(id);
}

}
