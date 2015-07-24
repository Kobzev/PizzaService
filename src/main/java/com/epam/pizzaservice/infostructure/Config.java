package com.epam.pizzaservice.infostructure;

public interface Config {
	Class<?> getImplementation(String beanName);
}
