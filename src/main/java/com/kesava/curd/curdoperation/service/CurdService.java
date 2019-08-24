package com.kesava.curd.curdoperation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kesava.curd.curdoperation.model.Customer;
import com.kesava.curd.curdoperation.repository.CurdRepo;

@Service
public class CurdService {

	@Autowired
	private CurdRepo curdRepo;
	
	public void saveAllCustomer(Iterable<Customer> customer) {
		curdRepo.saveAll(customer);
	}
	
	public void saveCustomer(Customer customer) {
		curdRepo.save(customer);
	}
	
	public Iterable<Customer> getAllCustomer() {
		return curdRepo.findAll();
	}
	
	public Optional<Customer> getByCustomerId(int id) {
		return curdRepo.findById(id);
	}
	
	public void deleteByCustomer(int id) {
		curdRepo.deleteById(id);
	}
	
	
}
