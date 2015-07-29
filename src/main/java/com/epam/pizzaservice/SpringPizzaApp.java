package com.epam.pizzaservice;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.repository.PizzaRepository;
import com.epam.pizzaservice.service.OrderService;

public class SpringPizzaApp {
	public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryConfig.xml");
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repositoryContext);
        PizzaRepository pizzaRepository = (PizzaRepository)appContext.getBean("pizzaRepository");
        System.out.println(pizzaRepository);

        String[] beans = appContext.getBeanDefinitionNames();
        for (String string : beans) {
            System.out.println(string);
        }

        Object service = appContext.getBean("orderService");
        
        OrderService orderService = (OrderService)service;
        Order order = orderService.placeNewOrder(null, 1, 2, 3);
        System.out.println(order);

        System.out.println(appContext.getBean("order"));
        System.out.println(appContext.getBean("order"));

        appContext.close();
        repositoryContext.close();
    }

}
