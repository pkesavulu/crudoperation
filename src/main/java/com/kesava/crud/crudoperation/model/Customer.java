package com.kesava.crud.crudoperation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String Email;
	private String phone;
	private long currentbalance;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getCurrentbalance() {
		return currentbalance;
	}
	public void setCurrentbalance(long currentbalance) {
		this.currentbalance = currentbalance;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", Email=" + Email + ", phone=" + phone + ", currentbalance="
				+ currentbalance + "]";
	}
}
