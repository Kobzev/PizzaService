package com.epam.pizzaservice.domain;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TotalOrderCostCalculatorTest {
	
	public static double DELTA = 0.001;
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPrice_ThrowException_WithOutPizza(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPrice_ThrowException_BiggestThenTenPizzas(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1, "Some name", 10.11, PizzaType.MEAT), 15);
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
	}
	
	@Test
	public void testCalculateTotalOrderPrice_OnePizza(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		double pizzaPrice = 45.60;
		pizzas.put(new Pizza(1, "Some name", pizzaPrice, PizzaType.MEAT), 1);
		double expectedPrice = 45.60;
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		double price = totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
		assertEquals(expectedPrice, price, DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPrice_ThrowException_PizzaCountIsNegative(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1, "Some name", 10.11, PizzaType.MEAT), 3);
		pizzas.put(new Pizza(1, "Some name", 10.11, PizzaType.MEAT), -2);
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPrice_ThrowException_PizzaCountIsZero(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1, "Some name", 10.11, PizzaType.MEAT), 3);
		pizzas.put(new Pizza(1, "Some name", 10.11, PizzaType.MEAT), 0);
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateTotalOrderPrice_ThrowException_IfPizzaIsNull(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1, "Some name", 10.11, PizzaType.MEAT), 3);
		pizzas.put(null, 3);
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateTotalOrderPrice_ThrowException_IfPizzasIsNull(){
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(null);
		
	}

}
