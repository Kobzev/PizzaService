package com.epam.pizzaservice.service;

import com.epam.pizzaservice.domain.Customer;

public interface CustomerService {
	Customer getCustomerById(Long id);
}
