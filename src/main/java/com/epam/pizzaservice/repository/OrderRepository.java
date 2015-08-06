package com.epam.pizzaservice.repository;

import com.epam.pizzaservice.domain.Order;

public interface OrderRepository {
	@Deprecated
	void saveOrder(Order newOrder);
	Order getOrderById(Long id);
	Long save(Order order);
}