package com.rd.pizzaservice.repository;

import java.util.List;

import com.rd.pizzaservice.domain.Pizza;

public interface PizzaRepository {
	Pizza getPizzaByID(Long id);
	List<Pizza> getAllPizzas();
	Long save(Pizza pizza);
}