package com.kesava.curd.curdoperation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kesava.curd.curdoperation.model.Customer;
import com.kesava.curd.curdoperation.service.CurdService;

@Controller
public class CurdController {

@Autowired
private CurdService curdService;
	
@GetMapping(value = "/")
@ResponseBody
public String hello() {
	return "<h1>welcome to my project</h1>";
}

@GetMapping(value = "/createcustomer")
@ResponseBody
public void createCustomer(Customer customer) {
	curdService.saveCustomer(customer);
}

@GetMapping(value = "/getallcustomer")
@ResponseBody
public Iterable<Customer> getAllCustomer() {
	return curdService.getAllCustomer(); 
}

@GetMapping(value = "/getcustomer/{id}")
@ResponseBody
public Optional<Customer> getCustomer(int id) {
	return curdService.getByCustomerId(id);
}

@PutMapping(value = "/update/{id}")
@ResponseBody
public void updateCustomer(@RequestParam("customer")Customer customer,@RequestParam("id") int id) {
	curdService.saveCustomer(customer);
}

@DeleteMapping(value = "/delete/{id}")
public void deleteCustomer(@RequestParam("id") int id) {
	curdService.deleteByCustomer(id);
}

}
