package com.epam.pizzaservice.repository.implementation;

import java.util.ArrayList;
import java.util.List;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.domain.PizzaType;
import com.epam.pizzaservice.infostructure.Benchmark;

public class TestPizzaRepository {//implements PizzaRepository {
	private List<Pizza> listOfPizza;
	
	//@Override
	@Benchmark
	public Pizza getPizzaByID(Long id) {
		for (Pizza pizza : listOfPizza) if(pizza.getId().equals(id)) return pizza;
		return null;
	}
	
	public void setListOfPizza(List<Pizza> listOfPizza) {
		this.listOfPizza = listOfPizza;
	}

	public void init(){
		listOfPizza = new ArrayList<Pizza>();
		listOfPizza.add(new Pizza(1L, "VEGETERIAN", 55.30, PizzaType.VEGETERIAN));
		listOfPizza.add(new Pizza(2L, "SEA", 68.30, PizzaType.SEA));
		listOfPizza.add(new Pizza(3L, "MEAT", 65.30, PizzaType.MEAT));
	}

	//@Override
	public List<Pizza> getAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Integer save(Pizza pizza) {
		// TODO Auto-generated method stub
		return null;
	}

}
