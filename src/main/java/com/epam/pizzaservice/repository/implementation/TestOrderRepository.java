package com.epam.pizzaservice.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.infostructure.Benchmark;
import com.epam.pizzaservice.repository.OrderRepository;

@Repository
public class TestOrderRepository implements OrderRepository {
	private static List<Order> staticListOfOrders;

	static{
		staticListOfOrders = new ArrayList<Order>();
	}
	
	@Override
	@Benchmark
	public void saveOrder(Order newOrder) {
		//newOrder.setId(staticListOfOrders.size()+1);
		staticListOfOrders.add(newOrder);		
	}
}
