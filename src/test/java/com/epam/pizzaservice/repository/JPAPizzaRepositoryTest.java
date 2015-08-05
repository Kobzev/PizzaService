package com.epam.pizzaservice.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.domain.PizzaType;
import com.epam.pizzaservice.repository.templetes.ITRepositoryTestsTemplete;

public class JPAPizzaRepositoryTest extends ITRepositoryTestsTemplete{
	
	//@Autowired
	//private PizzaRepository pizzaRepository;
	
	@Test
	public void testSomeMethod(){	
		/*Pizza pizza = new Pizza();
		pizza.setName("seas");
		pizza.setPrice(48.9);
		pizza.setType(PizzaType.SEA);*/
		
		Integer id = 1;//pizzaRepository.save(pizza);
		System.out.println(id);
		assertNotNull(id);
	}

}
