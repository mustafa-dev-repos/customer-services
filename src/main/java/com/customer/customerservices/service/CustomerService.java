package com.customer.customerservices.service;

import java.util.List;

import com.customer.customerservices.model.Customer;

public interface CustomerService {
	public List<Customer> getCustomerByCustomerId(Integer customerId);
	
	public List<Customer> getCustomerByCustomerName(String customerName);

	public List<Customer> getCustomerByCustomerLastname(String customerLastname);
	
	public List<Customer> getCustomerByActiveTrue();
	
	public List<Customer> getCustomerByActiveFalse();
	
	public List<Customer> getCustomerByAgeEqualto(Integer age);
	
	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public void deleteCustomer(Integer customerId);
	
	public List<Customer> getAllCustomers();
	
}
