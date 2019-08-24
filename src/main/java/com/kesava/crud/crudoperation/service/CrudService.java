package com.kesava.crud.crudoperation.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kesava.crud.crudoperation.model.Customer;
import com.kesava.crud.crudoperation.repository.CrudRepo;

@Service
public class CrudService {
	static Logger logger = Logger.getLogger(CrudService.class);
	
	@Autowired
	private CrudRepo crudRepo;

	public void saveAllCustomer(Iterable<Customer> customer) {
		logger.info("save all the customers data");
		crudRepo.saveAll(customer);
	}

	public void saveCustomer(Customer customer) {
		logger.info("save the customer data");
		crudRepo.save(customer);
	}

	public Iterable<Customer> getAllCustomers() {
		logger.info("find all the customers");
		return crudRepo.findAll();
	}

	public Optional<Customer> getByCustomerId(Integer id) {
		logger.info("find the customer");
		return crudRepo.findById(id);
	}

	public void deleteByCustomer(int id) {
		logger.info("delete the customer");
		crudRepo.deleteById(id);
	}

	public Customer updateCustomerBalance(Integer id, long currentbalance) {
		Customer customer = crudRepo.findById(id).orElse(null);
		customer.setCurrentbalance(currentbalance);
		Customer updatedCustomer = crudRepo.save(customer);
		logger.info("update the customer");
		return updatedCustomer;

	}

}
