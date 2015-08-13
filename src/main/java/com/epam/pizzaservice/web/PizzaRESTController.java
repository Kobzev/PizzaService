package com.epam.pizzaservice.web;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.epam.pizzaservice.domain.Pizza;

@RestController
public class PizzaRESTController extends AbstractBinder{
	
	@RequestMapping(method = RequestMethod.GET, value = "hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<>("hello from RESTController", HttpStatus.I_AM_A_TEAPOT);
	}
	
	@RequestMapping(value="/pizzas/{pizzaId}", method = RequestMethod.GET)
	public ResponseEntity<Pizza> getPizzaById(@PathVariable("pizzaId") Pizza pizza){
		if (pizza == null) return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
	}
	
	@RequestMapping(value="/pizzas/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Pizza>> getAllPizzas(){
		return new ResponseEntity<List<Pizza>>(pizzaService.getAllPizzas(), HttpStatus.OK);
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			value="/pizzas/add", 
			headers = "content-type=application/json"
			)
	public ResponseEntity<Pizza> createNewPizza(@RequestBody Pizza pizza, UriComponentsBuilder builder){
		System.out.println(pizza);
		Long id = pizzaService.save(pizza);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				builder.path("/rest/pizzas/{id}")
				.buildAndExpand(pizza.getId()).toUri());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

}
