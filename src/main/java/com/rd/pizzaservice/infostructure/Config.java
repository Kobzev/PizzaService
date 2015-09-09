package com.rd.pizzaservice.infostructure;

public interface Config {
	Class<?> getImplementation(String beanName);
}
