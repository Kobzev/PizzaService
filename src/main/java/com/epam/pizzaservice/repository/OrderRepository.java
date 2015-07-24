package com.epam.pizzaservice.repository;

import com.epam.pizzaservice.domain.Order;

public interface OrderRepository {

	void saveOrder(Order newOrder);

}