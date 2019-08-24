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

	public Iterable<Customer> getAllCustomers() {
		return curdRepo.findAll();
	}

	public Optional<Customer> getByCustomerId(Integer id) {
		return curdRepo.findById(id);
	}

	public void deleteByCustomer(int id) {
		curdRepo.deleteById(id);
	}

	public Customer updateCustomerBalance(Integer id, long currentbalance) {
		Customer customer = curdRepo.findById(id).orElse(null);
		customer.setCurrentbalance(currentbalance);
		Customer updatedCustomer = curdRepo.save(customer);
		return updatedCustomer;

	}

}
