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
		pizzas.put(new Pizza(1L, "Some name", 10.11, PizzaType.MEAT), 15);
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
	}
	
	@Test
	public void testCalculateTotalOrderPrice_OnePizza(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		double pizzaPrice = 45.60;
		pizzas.put(new Pizza(1L, "Some name", pizzaPrice, PizzaType.MEAT), 1);
		double expectedPrice = 45.60;
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		double price = totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
		assertEquals(expectedPrice, price, DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPrice_ThrowException_PizzaCountIsNegative(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1L, "Some name", 10.11, PizzaType.MEAT), 3);
		pizzas.put(new Pizza(1L, "Some name", 10.11, PizzaType.MEAT), -2);
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateTotalOrderPrice_ThrowException_PizzaCountIsZero(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1L, "Some name", 10.11, PizzaType.MEAT), 3);
		pizzas.put(new Pizza(1L, "Some name", 10.11, PizzaType.MEAT), 0);
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateTotalOrderPrice_ThrowException_IfPizzaIsNull(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1L, "Some name", 10.11, PizzaType.MEAT), 3);
		pizzas.put(null, 3);
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateTotalOrderPrice_ThrowException_IfPizzasIsNull(){
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.calculateTotalOrderPrise(null);
		
	}
	
	@Test
	public void testCalculateTotalOrderPrice_ThreeDifferentPizza(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1L, "Some name", 45.60, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(2L, "Some name", 55.60, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(3L, "Some name", 35.60, PizzaType.MEAT), 1);
		double expectedPrice = 136.80;
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		double price = totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
		assertEquals(expectedPrice, price, DELTA);
	}
	
	@Test
	public void testCalculateTotalOrderPrice_FourDifferentPizza(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1L, "Some name", 45.60, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(2L, "Some name", 55.60, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(3L, "Some name", 35.60, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(4L, "Some name", 45.60, PizzaType.MEAT), 1);
		double expectedPrice = 182.40;
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		double price = totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
		assertEquals(expectedPrice, price, DELTA);
	}
	
	@Test
	public void testCalculateTotalOrderPrice_FiveDifferentPizza(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1L, "Some name", 30.00, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(2L, "Some name", 60.00, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(3L, "Some name", 30.00, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(4L, "Some name", 45.00, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(5L, "Some name", 45.00, PizzaType.MEAT), 1);
		//60 - max price
		//60 - 30% = 42 
		// 30+30+45+45+42 = 192
		double expectedPrice = 192.00;
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		double price = totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
		assertEquals(expectedPrice, price, DELTA);
	}
	
	@Test
	public void testCalculateTotalOrderPrice_FiveDifferentPizzaTwoMaxPrice(){
		Map<Pizza, Integer> pizzas = new HashMap<>();
		pizzas.put(new Pizza(1L, "Some name", 30.00, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(2L, "Some name", 60.00, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(3L, "Some name", 60.00, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(4L, "Some name", 45.00, PizzaType.MEAT), 1);
		pizzas.put(new Pizza(5L, "Some name", 45.00, PizzaType.MEAT), 1);
		//60 - max price
		//60 - 30% = 42 
		// 30+60+45+45+42 = 222
		double expectedPrice = 222.00;
		
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		double price = totalOrderCostCalculator.calculateTotalOrderPrise(pizzas);
		
		assertEquals(expectedPrice, price, DELTA);
	}
	
	@Test
	public void testCountDiscount_normalPercent(){
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		double discount = totalOrderCostCalculator.countDiscount(100, 30);
		double expectedDiscount = 30.00;
		
		assertEquals(expectedDiscount, discount, DELTA);
	}
	
	@Test
	public void testCountDiscount_zeroPercent(){
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		double discount = totalOrderCostCalculator.countDiscount(100, 0);
		double expectedDiscount = 0.00;
		
		assertEquals(expectedDiscount, discount, DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCountDiscount_negativePercent(){
		TotalOrderCostCalculator totalOrderCostCalculator = new TotalOrderCostCalculator();
		totalOrderCostCalculator.countDiscount(100, -30);
	}

}
