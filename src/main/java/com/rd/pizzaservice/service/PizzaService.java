package com.rd.pizzaservice.service;

import java.util.List;

import com.rd.pizzaservice.domain.Pizza;

public interface PizzaService {
	Pizza getPizzaByID(Long id);
	List<Pizza> getAllPizzas();
	
	Long save(Pizza pizza);
	Long update(Pizza pizza);
}