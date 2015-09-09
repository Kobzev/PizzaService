package com.rd.pizzaservice.service;

import com.rd.pizzaservice.domain.Customer;
import com.rd.pizzaservice.domain.Order;

public interface OrderService {

	Order placeNewOrder(Customer customer, Long... pizzasID);
	Order getOrderByID(Long id);
	Long save(Order order);

}