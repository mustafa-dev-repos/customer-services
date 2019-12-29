package com.customer.customerservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.customerservices.model.Customer;
import com.customer.customerservices.repository.CustomerRepository;
import com.customer.customerservices.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomerByCustomerId(Integer customerId) {
		return customerRepository.findByCustomerId(customerId);
	}

	@Override
	public List<Customer> getCustomerByCustomerName(String customerName) {
		return customerRepository.findByCustomerName(customerName);
	}

	@Override
	public List<Customer> getCustomerByCustomerLastname(String customerLastname) {
		return customerRepository.findByCustomerLastname(customerLastname);
	}

	@Override
	public List<Customer> getCustomerByActiveTrue() {
		return customerRepository.findByActiveTrue();
	}

	@Override
	public List<Customer> getCustomerByActiveFalse() {
		return customerRepository.findByActiveFalse();
	}

	@Override
	public List<Customer> getCustomerByAgeEqualto(Integer age) {
		return customerRepository.findByAgeEqualto(age);
	}

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		Customer findCustomer = customerRepository.findByCustomerId(customerId).stream().findFirst().get();
		customerRepository.delete(findCustomer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerRepository.findAll().iterator().forEachRemaining(customerList::add); 
		return customerList;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return null;
	}

}
