package com.epam.pizzaservice.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.repository.templetes.ITRepositoryTestsTemplete;

public class JPAOrderRepositoryTest extends ITRepositoryTestsTemplete{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void OrderRepository_testSaveMethod_NormalWork(){
		Order order = new Order();
		//order.setCustomer(null);
		
		Long id = orderRepository.save(order);
		System.out.println(id);
		assertNotNull(id);
		
	}
	
	@Test
	public void OrderRepository_testGetOrderById_NormalWork(){
		Order order = orderRepository.getOrderById(1L);
		
		Long id = order.getId();
		System.out.println(id);
		assertNotNull(id);
		
	}
	
	@Test
	public void OrderRepository_testGetOrderById_OrderWithCustomer_NormalWork(){
		Order order = orderRepository.getOrderById(2L);
		
		Long id = order.getId();
		System.out.println(id);
		assertNotNull(id);
		
	}
	
	@Test
	public void OrderRepository_testGetOrderById_OrderWithMap_NormalWork(){
		Order order = orderRepository.getOrderById(3L);
		
		Integer size = null;
		try {
			size = order.getPizzaMap().size();
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		System.out.println(size);
		assertNotNull(size);
		
	}
}
