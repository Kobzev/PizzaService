package com.epam.pizzaservice;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.pizzaservice.repository.PizzaRepository;

public class SpringPizzaApp {
	public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
        PizzaRepository pizzaRepository = (PizzaRepository)appContext.getBean("pizzaRepository");
        System.out.println(pizzaRepository);
        
        String[] beans = appContext.getBeanDefinitionNames();
        for (String string : beans) {
			System.out.println(string);
		}
        
        appContext.close();
    }

}
