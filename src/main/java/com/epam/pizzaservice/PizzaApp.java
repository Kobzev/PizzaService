package com.epam.pizzaservice;

import com.epam.pizzaservice.domain.Customer;
import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.infostructure.ApplicationContext;
import com.epam.pizzaservice.infostructure.Config;
import com.epam.pizzaservice.infostructure.JavaConfig;
import com.epam.pizzaservice.infostructure.JavaConfigApplicationContext;
//import com.epam.pizzaservice.infostructure.ObjectFactory;
import com.epam.pizzaservice.repository.PizzaRepository;
import com.epam.pizzaservice.service.OrderService;
//import com.epam.pizzaservice.service.SimpleOrderService;

public class PizzaApp {
	public static void main(String[] args) throws Exception {
        Customer customer = null;        
        Order order;
        
        //ObjectFactory objectFactory = ObjectFactory.getInstance();        
        //OrderService orderService = (OrderService)objectFactory.createObject("orderService");
        
        Config config = new JavaConfig();
        ApplicationContext context = new JavaConfigApplicationContext(config);
        PizzaRepository pizzaRepository = (PizzaRepository)context.getBean("pizzaRepository");
        
        System.out.println(pizzaRepository);
        
        //OrderService orderService = new SimpleOrderService(orderRepository, pizzaRepository);
        OrderService orderService = (OrderService)context.getBean("orderService");
        order = orderService.placeNewOrder(customer, 1, 2, 3);
        
        System.out.println(order);
    }

}
