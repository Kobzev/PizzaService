package com.epam.pizzaservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.domain.PizzaType;
import com.epam.pizzaservice.service.PizzaService;

@Controller("pizzaController")
@RequestMapping(value="/pizza")
public class PizzaController{
	
	@Autowired
	private PizzaService pizzaService;
	
	/*@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring MVC";		
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String handleDefaultRequest(Model model) throws Exception {
		model.addAttribute("msg", "Hello Spring MVC");
		return "hello";
	}*/
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String viewPizzas(Model model){
		model.addAttribute("pizzas", pizzaService.getAllPizzas());
		return "show";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createPizza(Model model){
		model.addAttribute("pizza", new Pizza());
		return "addpizza";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	//public String createNewPizza(@ModelAttribute Pizza pizza){
	public String createNewPizza(@RequestParam String name, @RequestParam Double price, @RequestParam PizzaType type){
		Pizza pizza = new Pizza();
		pizza.setName(name);
		pizza.setPrice(price);
		pizza.setType(type);
		pizzaService.save(pizza);
		return "redirect:show";
	}

}
