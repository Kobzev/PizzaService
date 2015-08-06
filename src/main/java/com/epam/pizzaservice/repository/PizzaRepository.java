package com.epam.pizzaservice.repository;

import java.util.List;

import com.epam.pizzaservice.domain.Pizza;

public interface PizzaRepository {
	Pizza getPizzaByID(Long id);
	List<Pizza> getAllPizzas();
	Long save(Pizza pizza);
}