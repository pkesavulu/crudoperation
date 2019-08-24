package com.kesava.crud.crudoperation.controller;

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

import com.kesava.crud.crudoperation.model.Customer;
import com.kesava.crud.crudoperation.service.CrudService;

@Controller
public class CrudController {

@Autowired
private CrudService crudService;
	
@GetMapping(value = "/")
@ResponseBody
public String hello() {
	return "<h1>welcome to my project</h1>";
}

@PostMapping(value = "/createcustomer")
public void addCustomer(@RequestBody Customer customer) {
	crudService.saveCustomer(customer);
}

@GetMapping(value = "/getallcustomer")
@ResponseBody
public Iterable<Customer> getAllCustomers() {
	return crudService.getAllCustomers(); 
}

@GetMapping(value = "/getcustomer/{id}")
@ResponseBody
public Optional<Customer> getCustomer(@RequestParam("id") Integer id) {
	return crudService.getByCustomerId(id);
}

@PutMapping(value = "/update/{id}/{currentbalance}")
@ResponseBody
public Customer updateCustomer(@RequestParam("id") Integer id,@RequestParam("currentbalance") long currentbalance) {
	return crudService.updateCustomerBalance(id,currentbalance);
}

@DeleteMapping(value = "/delete/{id}")
public void deleteCustomer(@RequestParam("id") Integer id) {
	crudService.deleteByCustomer(id);
}

}
