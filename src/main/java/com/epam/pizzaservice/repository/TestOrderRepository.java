package com.epam.pizzaservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.epam.pizzaservice.domain.Order;

public class TestOrderRepository implements OrderRepository {
	private static List<Order> staticListOfOrders;

	static{
		staticListOfOrders = new ArrayList<Order>();
	}
	
	/* (non-Javadoc)
	 * @see com.epam.pizzaservice.repository.OrderRepository#saveOrder(com.epam.pizzaservice.domain.Order)
	 */
	@Override
	public void saveOrder(Order newOrder) {
		newOrder.setId(staticListOfOrders.size()+1);
		staticListOfOrders.add(newOrder);		
	}
}
