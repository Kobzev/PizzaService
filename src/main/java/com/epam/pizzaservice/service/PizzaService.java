package com.epam.pizzaservice.service;

import com.epam.pizzaservice.domain.Pizza;

public interface PizzaService {
	Pizza getPizzaByID(Integer id);
}