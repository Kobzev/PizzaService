package com.rd.pizzaservice.domain;

import java.util.Map;
import java.util.Map.Entry;

public class TotalOrderCostCalculator {
	
	public double calculateTotalOrderPrise(Map<Pizza, Integer> pizzas){
		if (pizzas == null) throw new NullPointerException("");
		
		double price = 0;
		int amount = 0;
		Pizza biggestPricePizza = null;
		for (Entry<Pizza, Integer> pizzaEntry : pizzas.entrySet()){
			int amoutPizza = pizzaEntry.getValue();
			if (amoutPizza < 1) throw new IllegalArgumentException("");
			
			Pizza pizza = pizzaEntry.getKey();
			if (pizza == null) throw new NullPointerException("");
			
			if (biggestPricePizza == null) biggestPricePizza = pizza;
			else {if (biggestPricePizza.getPrice() < pizza.getPrice()) biggestPricePizza = pizza;}
			
			price += amoutPizza*pizza.getPrice();
			amount += amoutPizza;
		}	
		
		if (amount > 10 || amount < 1) throw new IllegalArgumentException("");
		
		if (amount > 4) price-= countDiscount(biggestPricePizza.getPrice(), 30);
		
		return price;
	}
	
	public double countDiscount(double price, double percent){
		if (percent < 0) throw new IllegalArgumentException();
		return price*percent/100;
	}

}
