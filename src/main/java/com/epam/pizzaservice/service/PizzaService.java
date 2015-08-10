package com.epam.pizzaservice.service;

import java.util.List;

import com.epam.pizzaservice.domain.Pizza;

public interface PizzaService {
	Pizza getPizzaByID(Long id);
	List<Pizza> getAllPizzas();
	Long save(Pizza pizza);
	Long update(Pizza pizza);
}