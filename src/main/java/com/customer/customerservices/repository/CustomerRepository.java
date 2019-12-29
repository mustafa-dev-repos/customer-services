package com.customer.customerservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.customerservices.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
	@Query(value= "Select * from customer c where c.customer_id=?1", nativeQuery = true)
	List<Customer> findByCustomerId(Integer customerId);
	
	@Query(value= "Select * from customer c where c.name like %?1", nativeQuery = true)
	List<Customer> findByCustomerName(String customerName);

	@Query(value= "Select * from customer c where c.lastName like %?1", nativeQuery = true)
	List<Customer> findByCustomerLastname(String customerLastname);
	
	@Query(value= "Select * from customer c where c.status='A'", nativeQuery = true)
	List<Customer> findByActiveTrue();
	
	@Query(value= "Select * from customer c where c.status='P'", nativeQuery = true)
	List<Customer> findByActiveFalse();
	
	@Query(value= "Select * from customer c where c.customer_id=?1", nativeQuery = true)
	List<Customer> findByAgeEqualto(Integer age);
	
}
