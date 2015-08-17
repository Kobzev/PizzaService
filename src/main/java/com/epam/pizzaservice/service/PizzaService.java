package com.epam.pizzaservice.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.epam.pizzaservice.domain.Pizza;

public interface PizzaService {
	Pizza getPizzaByID(Long id);
	List<Pizza> getAllPizzas();
	
	@Secured("ROLE_ADMIN")
	Long save(Pizza pizza);
	Long update(Pizza pizza);
}