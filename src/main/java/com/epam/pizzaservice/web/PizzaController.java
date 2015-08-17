package com.epam.pizzaservice.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.pizzaservice.domain.Pizza;

@Controller("pizzaController")
@RequestMapping(value="/pizza")
public class PizzaController extends AbstractBinder{
	
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
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("user", authentication.getName().toString());
		
		model.addAttribute("user_roles", authentication.getAuthorities().toString());
		
		return "show";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createPizza(Model model){
		model.addAttribute("pizza", new Pizza());
		return "addpizza";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createNewPizza(@ModelAttribute Pizza pizza){
	/*public String createNewPizza(@RequestParam String name, @RequestParam Double price, @RequestParam PizzaType type){
		Pizza pizza = new Pizza();
		pizza.setName(name);
		pizza.setPrice(price);
		pizza.setType(type);*/
		pizzaService.save(pizza);
		return "redirect:show";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editPizza(@RequestParam("id") Pizza pizza, Model model){
		model.addAttribute("pizza", pizza);
		return "editpizza";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String savePizza(@ModelAttribute Pizza pizza){
		//if(null==null)throw new PizzaNotFoundException("Pizza not found");
		pizzaService.update(pizza);
		return "redirect:show";
	}
	
	/*@ExceptionHandler(PizzaNotFoundException.class)
	public ModelAndView exceptionHandler(Exception exception, HttpServletRequest request){
		ModelAndView model = new ModelAndView("error");
		model.addObject("ex", exception);
		model.addObject("url", request.getRequestURI());
		return model;
	}*/

}
