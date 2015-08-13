package com.epam.pizzaservice.repository;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.domain.PizzaType;
import com.epam.pizzaservice.repository.templetes.ITRepositoryTestsTemplete;

public class JPAPizzaRepositoryTest extends ITRepositoryTestsTemplete{
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Ignore
	@Test
	public void PizzaRepository_testSaveMethod_NormalWork(){	
		Pizza pizza = new Pizza();
		pizza.setName("seas");
		pizza.setPrice(48.9);
		pizza.setType(PizzaType.SEA);
		
		Long id = pizzaRepository.save(pizza);
		System.out.println(id);
		assertNotNull(id);
	}

}
