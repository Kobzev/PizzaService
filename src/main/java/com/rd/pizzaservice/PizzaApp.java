package com.rd.pizzaservice;

//import com.epam.pizzaservice.service.SimpleOrderService;
import com.rd.pizzaservice.domain.Customer;
import com.rd.pizzaservice.domain.Order;
import com.rd.pizzaservice.infostructure.ApplicationContext;
import com.rd.pizzaservice.infostructure.Config;
import com.rd.pizzaservice.infostructure.JavaConfig;
import com.rd.pizzaservice.infostructure.JavaConfigApplicationContext;
import com.rd.pizzaservice.repository.PizzaRepository;
import com.rd.pizzaservice.service.OrderService;

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
        order = orderService.placeNewOrder(customer, 1L, 2L, 3L);
        
        System.out.println(order);
    }

}
