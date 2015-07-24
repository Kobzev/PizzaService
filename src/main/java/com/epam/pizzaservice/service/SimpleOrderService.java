package com.epam.pizzaservice.service;

import java.util.ArrayList;
import java.util.List;


import com.epam.pizzaservice.domain.Customer;
import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.domain.Pizza;
//import com.epam.pizzaservice.infostructure.ObjectFactory;
import com.epam.pizzaservice.repository.OrderRepository;
import com.epam.pizzaservice.repository.PizzaRepository;

public class SimpleOrderService implements OrderService {
	//private ObjectFactory objectFactory = ObjectFactory.getInstance();
	
	private OrderRepository orderRepository;
	private PizzaRepository pizzaRepository;	
	
	@Override
	public Order placeNewOrder(Customer customer, Integer ... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
       
        for(Integer id : pizzasID){
            pizzas.add(pizzaRepository.getPizzaByID(id));  // get Pizza from predifined in-memory list
        }
        Order newOrder = new Order(customer, pizzas);
       
        
        orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }

	/*public SimpleOrderService() throws InstantiationException, IllegalAccessException {
		orderRepository = (OrderRepository)objectFactory.createObject("orderRepository");
		pizzaRepository = (PizzaRepository)objectFactory.createObject("pizzaRepository");
	}*/

	public SimpleOrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository) {
		this.orderRepository = orderRepository;
		this.pizzaRepository = pizzaRepository;
	}
	
	
	
	

	

	

}
