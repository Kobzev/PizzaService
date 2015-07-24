package com.epam.pizzaservice.service;

import com.epam.pizzaservice.domain.Customer;
import com.epam.pizzaservice.domain.Order;

public interface OrderService {

	Order placeNewOrder(Customer customer, Integer... pizzasID);

}