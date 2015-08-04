package com.epam.pizzaservice.repository;

import com.epam.pizzaservice.domain.Customer;

public interface CustomerRepository {
	Customer getCustomerById(Integer id);
}
