package com.epam.pizzaservice.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.repository.PizzaRepository;
import com.epam.pizzaservice.service.PizzaService;

@Service(value="pizzaService")
public class PizzaServiceImplementation implements PizzaService{
	
	@Autowired
	private PizzaRepository pizzaRepository;

	@Override
	public Pizza getPizzaByID(Long id) {
		return pizzaRepository.getPizzaByID(id);
	}

	@Override
	public List<Pizza> getAllPizzas() {
		return pizzaRepository.getAllPizzas();
	}

}
