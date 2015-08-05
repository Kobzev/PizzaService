package com.epam.pizzaservice.repository;

import java.util.List;

import com.epam.pizzaservice.domain.Pizza;

public interface PizzaRepository {
	Pizza getPizzaByID(Integer id);
	List<Pizza> getAllPizzas();
	Integer save(Pizza pizza);
}