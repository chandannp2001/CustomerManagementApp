package com.sunbase.dao;

import java.util.List;

import com.sunbase.model.Customer;


public interface CustomerDAO {

	void addCustomer(Customer customer);
	List<Customer> getCustomerByFirst_name(String first_name);
	List<Customer> getCustomerByEmail(String email);
	List<Customer> getCustomerByCity(String city);
	List<Customer> getCustomerByPhone_number(String phone_number);
	Customer getCustomerById(String customerId);
	void updateCustomer(Customer customer);
	void deleteCustomer(String customerId);
	List<Customer> getAllCustomer();
}
