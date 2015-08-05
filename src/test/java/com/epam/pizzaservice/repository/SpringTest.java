package com.epam.pizzaservice.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.domain.PizzaType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/repositoryConfig.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=true)
public class SpringTest {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Test
	public void testSomeMethod(){
		Pizza pizza = new Pizza();
		pizza.setName("seas");
		pizza.setPrice(48.9);
		pizza.setType(PizzaType.SEA);
		
		Integer id = pizzaRepository.save(pizza);
		System.out.println(id);
		assertNotNull(id);
	}
}
