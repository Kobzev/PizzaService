package com.epam.pizzaservice;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.domain.PizzaType;
import com.epam.pizzaservice.repository.PizzaRepository;
import com.epam.pizzaservice.service.OrderService;

public class SpringPizzaApp {
	public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext repositoryContext = new ClassPathXmlApplicationContext("repositoryConfig.xml");
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"}, repositoryContext);
        PizzaRepository pizzaRepository = (PizzaRepository)appContext.getBean("pizzaRepository");
        System.out.println(pizzaRepository);

        String[] beans = appContext.getBeanDefinitionNames();
        System.out.println("context start");
        for (String string : beans) {
            System.out.println(string);
        }
        System.out.println("context finish");

        Object service = appContext.getBean(OrderService.class);
        
        OrderService orderService = (OrderService)service;
        Order order = orderService.placeNewOrder(null, 1, 2, 3);
        System.out.println(order);
        
        order = orderService.placeNewOrder(null, 1, 2, 3);
        System.out.println(order);

        System.out.println(appContext.getBean("order"));
        System.out.println(appContext.getBean("order"));
        
        for (Pizza piz : pizzaRepository.getAllPizzas()){
        	System.out.println(piz);
        }
        
        org.springframework.beans.factory.config.PropertyPlaceholderConfigurer config = (org.springframework.beans.factory.config.PropertyPlaceholderConfigurer)appContext.getBean("propertyConfigure");
        System.out.println(config.toString());
        
        //pizzaRepository.save(new Pizza(null, "Vegetarian", 71.30, PizzaType.VEGETERIAN));
        System.out.println(pizzaRepository.getPizzaByID(1));

        appContext.close();
        repositoryContext.close();
    }

}
