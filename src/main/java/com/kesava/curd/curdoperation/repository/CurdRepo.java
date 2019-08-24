package com.kesava.curd.curdoperation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kesava.curd.curdoperation.model.Customer;

@Repository
public interface CurdRepo extends CrudRepository<Customer,Integer>{

}
