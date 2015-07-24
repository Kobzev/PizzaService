package com.epam.pizzaservice.repository;

import com.epam.pizzaservice.domain.Pizza;

public interface PizzaRepository {

	Pizza getPizzaByID(Integer id);

}