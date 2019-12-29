package com.customer.customerservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.customerservices.model.Customer;
import com.customer.customerservices.service.CustomerService;

@Controller
@RequestMapping(path = "/api")
public class CustomerServiceRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path = "/createCustomer")
	public ResponseEntity<Customer> createCustomer (@RequestBody Customer customer){
		 HttpStatus httpStatus = HttpStatus.CREATED;
		 Customer customerSaved = customerService.createCustomer(customer);
		 return new ResponseEntity<>(customerSaved, httpStatus);
	}
	
	@GetMapping(path = "/findCustomer/{customerId}")
	public ResponseEntity<List<Customer>> findCustomerByCustomerId (@PathVariable Integer customerId){
		 HttpStatus httpStatus = HttpStatus.FOUND;
		 List<Customer> customerListSaved = customerService.getCustomerByCustomerId(customerId);
		 return new ResponseEntity<List<Customer>>(customerListSaved, httpStatus);
	}
	
	@GetMapping(path = "/findAllCustomer")
	public ResponseEntity<List<Customer>> findAllCustomer (){
		 HttpStatus httpStatus = HttpStatus.FOUND;
		 List<Customer> customerListSaved = customerService.getAllCustomers();
		 return new ResponseEntity<List<Customer>>(customerListSaved, httpStatus);
	}

}
