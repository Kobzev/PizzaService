package com.epam.pizzaservice.domain;

import java.util.Map;
import java.util.Map.Entry;

public class TotalOrderCostCalculator {
	
	public double calculateTotalOrderPrise(Map<Pizza, Integer> pizzas){
		if (pizzas == null) throw new NullPointerException("");
		
		double price = 0;
		int amount = 0;
		for (Entry<Pizza, Integer> pizzaEntry : pizzas.entrySet()){
			int amoutPizza = pizzaEntry.getValue();
			if (amoutPizza < 1) throw new IllegalArgumentException("");
			
			Pizza pizza = pizzaEntry.getKey();
			if (pizza == null) throw new NullPointerException("");
			
			price += amoutPizza*pizza.getPrice();
			amount += amoutPizza;
		}	
		
		if (amount > 10 || amount < 1) throw new IllegalArgumentException("");
		
		return price;
	}

}
