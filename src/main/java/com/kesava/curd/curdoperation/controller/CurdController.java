package com.kesava.curd.curdoperation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

@PostMapping(value = "/createcustomer")
public void addCustomer(@RequestBody Customer customer) {
	curdService.saveCustomer(customer);
}

@GetMapping(value = "/getallcustomer")
@ResponseBody
public Iterable<Customer> getAllCustomers() {
	return curdService.getAllCustomers(); 
}

@GetMapping(value = "/getcustomer/{id}")
@ResponseBody
public Optional<Customer> getCustomer(@RequestParam("id") Integer id) {
	return curdService.getByCustomerId(id);
}

@PutMapping(value = "/update/{id}/{currentbalance}")
@ResponseBody
public Customer updateCustomer(@RequestParam("id") Integer id,@RequestParam("currentbalance") long currentbalance) {
	return curdService.updateCustomerBalance(id,currentbalance);
}

@DeleteMapping(value = "/delete/{id}")
public void deleteCustomer(@RequestParam("id") Integer id) {
	curdService.deleteByCustomer(id);
}

}
