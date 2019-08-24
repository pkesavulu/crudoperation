package com.kesava.curd.curdoperation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kesava.curd.curdoperation.model.Customer;

@Controller
public class CurdController {

	
@GetMapping(value = "/")
@ResponseBody
public String hello() {
	return "<h1>welcome to my project</h1>";
}

@GetMapping(value = "/createcustomer")
@ResponseBody
public void createCustomer(Customer customer) {
	
}

@GetMapping(value = "/getcustomer/{id}")
@ResponseBody
public void getCustomer(int id) {
	
}

@PutMapping(value = "/update/{id}")
@ResponseBody
public void updateCustomer(int id) {
	
}

@DeleteMapping(value = "/delete/{id}")
@ResponseBody
public void deleteCustomer(int id) {
	
}

}
