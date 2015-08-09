package com.epam.pizzaservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.pizzaservice.service.PizzaService;

@Controller("helloController")
public class HelloSpringMVC{
	
	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring MVC";		
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String handleDefaultRequest(Model model) throws Exception {
		model.addAttribute("msg", "Hello Spring MVC");
		return "hello";
	}
	
	@RequestMapping(value="/pizzas", method=RequestMethod.GET)
	public String viewPizzas(Model model){
		model.addAttribute("pizzas", pizzaService.getAllPizzas());
		return "pizzas";
	}

}
