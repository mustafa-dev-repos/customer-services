package com.customer.customerservices;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.customer.customerservices.model.Customer;
import com.customer.customerservices.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerServicesRepositoryTests {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testCustomerSaveAndFindAll() throws Exception {
		try {
			System.out.println("Test of testCustomerSaveAndFindAll");
			Customer customer = new Customer();
			customer.setName("CustomerName-1");
			customer.setLastname("CustomerLastname-1");
			testEntityManager.persist(customer);
			customerRepository.save(customer);
			List<Customer> customerList = new ArrayList<Customer>();
			customerRepository.findAll().iterator().forEachRemaining(customerList::add);
			assertEquals(customerList.get(0).getName(), "CustomerName-1");
			assertEquals(customerList.get(0).getLastname(), "CustomerLastname-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCustomerFindById() throws Exception {
		try {
			System.out.println("Test of testCustomerFindById");
			Customer customer = new Customer();
			customer.setName("CustomerName-2");
			customer.setLastname("CustomerLastname-2");
			testEntityManager.persist(customer);
			customerRepository.save(customer);
			List<Customer> customerList = new ArrayList<Customer>();
			customerRepository.findAll().iterator().forEachRemaining(customerList::add);
			List<Customer> listOfCustomer = customerRepository.findByCustomerId(customerList.get(0).getCustomerId());
			System.out.println("Customer Id : " + listOfCustomer.get(0).getCustomerId());
			assertEquals(listOfCustomer.get(0).getName(), "CustomerName-2");
			assertEquals(listOfCustomer.get(0).getLastname(), "CustomerLastname-2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
