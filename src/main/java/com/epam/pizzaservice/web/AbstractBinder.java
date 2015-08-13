package com.epam.pizzaservice.web;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.exception.PizzaNotFoundException;
import com.epam.pizzaservice.service.PizzaService;

abstract class AbstractBinder {
	@Autowired
	protected PizzaService pizzaService;
	
	private Pizza getPizzaById(Long id){
		if (id <= 0) throw new IllegalArgumentException("ID<=0");
		Pizza pizza = pizzaService.getPizzaByID(id);
		if (pizza == null) throw new PizzaNotFoundException("Pizza id = " + id + " not found");
		return pizza;
	}
	
	@InitBinder
	private void pizzaBinder(WebDataBinder binder){
		binder.registerCustomEditor(Pizza.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String pizzaId){
				Pizza pizza = null;
				if (pizzaId!=null && !pizzaId.trim().isEmpty()){
					Long id = Long.parseLong(pizzaId);
					pizza = getPizzaById(id);
				}
				setValue(pizza);
			}
		});
	}

}
