package com.rd.pizzaservice.repository;

import com.rd.pizzaservice.domain.Customer;

public interface CustomerRepository {
	Customer getCustomerById(Long id);
	Long save(Customer customer);
}
