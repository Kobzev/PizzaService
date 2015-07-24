package com.epam.pizzaservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.domain.PizzaType;

public class TestPizzaRepository implements PizzaRepository {
	private List<Pizza> listOfPizza;
	
	@Override
	public Pizza getPizzaByID(Integer id) {
		for (Pizza pizza : listOfPizza) if(pizza.getId().equals(id)) return pizza;
		return null;
	}
	
	public void init(){
		listOfPizza = new ArrayList<Pizza>();
		listOfPizza.add(new Pizza(1, "VEGETERIAN", 55.30, PizzaType.VEGETERIAN));
		listOfPizza.add(new Pizza(2, "SEA", 68.30, PizzaType.SEA));
		listOfPizza.add(new Pizza(3, "MEAT", 65.30, PizzaType.MEAT));
	}

}
