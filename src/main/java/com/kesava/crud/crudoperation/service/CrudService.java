package com.kesava.crud.crudoperation.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kesava.crud.crudoperation.model.Customer;
import com.kesava.crud.crudoperation.repository.CrudRepo;
import com.kesava.crud.crudoperation.sns.NotificationService;

@Service
public class CrudService {
	static Logger logger = Logger.getLogger(CrudService.class);

	@Autowired
	private CrudRepo crudRepo;

	public void saveAllCustomer(Iterable<Customer> customer) {
		crudRepo.saveAll(customer);
		logger.info("Added the customers into a database");
	}

	public void saveCustomer(Customer customer) {
		crudRepo.save(customer);
		logger.info("Added " + customer.getName() + " into a database");
	}

	public Iterable<Customer> getAllCustomers() {
		logger.info("find all the customers");
		return crudRepo.findAll();
	}

	public Optional<Customer> getByCustomerId(Integer id) {
		logger.info("finding the customer :" + id);
		return crudRepo.findById(id);
	}

	public void deleteByCustomer(int id) {
		crudRepo.deleteById(id);
		logger.info("deleted customer :" + id);
	}

	public Customer updateCustomerBalance(Integer id, long currentbalance) {
		Customer customer = crudRepo.findById(id).orElse(null);
		customer.setCurrentbalance(currentbalance);
		Customer updatedCustomer = crudRepo.save(customer);
		logger.info("updated the " + customer.getName() + " currentbalance " + currentbalance + "into a database");
		return updatedCustomer;

	}

	public void sendSMS(String name, String currentbalance, String phone) {
		NotificationService.sendSMS(name, currentbalance, phone);
		logger.info("Hi " + name + " your current balance is : " + currentbalance + " /-");
	}

}
