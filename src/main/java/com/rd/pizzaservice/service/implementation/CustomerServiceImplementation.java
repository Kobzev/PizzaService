package com.rd.pizzaservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rd.pizzaservice.domain.Customer;
import com.rd.pizzaservice.repository.CustomerRepository;
import com.rd.pizzaservice.service.CustomerService;

@Service(value="customerService")
public class CustomerServiceImplementation implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.getCustomerById(id);
	}

}
