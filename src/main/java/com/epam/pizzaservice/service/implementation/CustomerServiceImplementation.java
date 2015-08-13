package com.epam.pizzaservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pizzaservice.domain.Customer;
import com.epam.pizzaservice.repository.CustomerRepository;
import com.epam.pizzaservice.service.CustomerService;

@Service(value="customerService")
public class CustomerServiceImplementation implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.getCustomerById(id);
	}

}
