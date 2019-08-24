package com.kesava.crud.crudoperation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kesava.crud.crudoperation.model.Customer;

@Repository
public interface CrudRepo extends CrudRepository<Customer,Integer>{

}
