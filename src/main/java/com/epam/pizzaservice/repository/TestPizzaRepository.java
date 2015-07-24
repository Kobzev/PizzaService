package com.epam.pizzaservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.domain.PizzaType;

public class TestPizzaRepository implements PizzaRepository {
	private static List<Pizza> staticListOfPizza;
	
	static{
		staticListOfPizza = new ArrayList<Pizza>();
		staticListOfPizza.add(new Pizza(1, "VEGETERIAN", 55.30, PizzaType.VEGETERIAN));
		staticListOfPizza.add(new Pizza(2, "SEA", 68.30, PizzaType.SEA));
		staticListOfPizza.add(new Pizza(3, "MEAT", 65.30, PizzaType.MEAT));		
	}
	
	/* (non-Javadoc)
	 * @see com.epam.pizzaservice.repository.PizzaRepository#getPizzaByID(java.lang.Integer)
	 */
	@Override
	public Pizza getPizzaByID(Integer id) {
		for (Pizza pizza : staticListOfPizza) if(pizza.getId().equals(id)) return pizza;
		return null;
	}

}
