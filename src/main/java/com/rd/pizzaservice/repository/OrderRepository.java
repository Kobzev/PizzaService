package com.rd.pizzaservice.repository;

import com.rd.pizzaservice.domain.Order;

public interface OrderRepository {
	@Deprecated
	void saveOrder(Order newOrder);
	Order getOrderById(Long id);
	Long save(Order order);
}