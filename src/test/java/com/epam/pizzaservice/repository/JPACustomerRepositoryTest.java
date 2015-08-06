package com.epam.pizzaservice.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.pizzaservice.domain.Customer;
import com.epam.pizzaservice.repository.templetes.ITRepositoryTestsTemplete;

public class JPACustomerRepositoryTest extends ITRepositoryTestsTemplete{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void CustomerRepository_testSaveMethod_NormalWork(){
		Customer customer = new Customer();
		customer.setAccumulativeCard(null);
		
		Long id = customerRepository.save(customer);
		System.out.println(id);
		assertNotNull(id);
		
	}
	
	@Test
	public void CustomerRepository_testGetCustomerById_NormalWork(){
		Customer customer = customerRepository.getCustomerById(1L);
		
		Long id = customer.getId();
		System.out.println(id);
		assertNotNull(id);
		
	}
	
	@Test
	public void CustomerRepository_testGetCustomerById_CustomerWithCard_NormalWork(){
		Customer customer = customerRepository.getCustomerById(2L);
		
		Long id = customer.getAccumulativeCard().getId();
		System.out.println(id);
		assertNotNull(id);
		
	}
}
