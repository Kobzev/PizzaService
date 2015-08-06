package com.epam.pizzaservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.epam.pizzaservice.domain.Customer;
import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.infostructure.Benchmark;
import com.epam.pizzaservice.repository.OrderRepository;
import com.epam.pizzaservice.repository.PizzaRepository;

@Service
public class SimpleOrderService implements OrderService {
		//, ApplicationContextAware {
	//private ObjectFactory objectFactory = ObjectFactory.getInstance();

	//private ApplicationContext appContext;
	private OrderRepository orderRepository;
	private PizzaRepository pizzaRepository;	
	
	@Override
	@Benchmark
	public Order placeNewOrder(Customer customer, Long ... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
       
        for(Long id : pizzasID){
            pizzas.add(pizzaRepository.getPizzaByID(id));  // get Pizza from predifined in-memory list
        }
        Order newOrder = getNewOrder();
		//newOrder.setCustomer(customer);
		//newOrder.setList(pizzas);
        
        orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }

	@Lookup(value="order")
	protected Order getNewOrder() {
		//Order order = (Order)appContext.getBean("order");
		return null;
	}

	/*public SimpleOrderService() throws InstantiationException, IllegalAccessException {
		orderRepository = (OrderRepository)objectFactory.createObject("orderRepository");
		pizzaRepository = (PizzaRepository)objectFactory.createObject("pizzaRepository");
	}*/

	@Autowired
	public SimpleOrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository) {
		this.orderRepository = orderRepository;
		this.pizzaRepository = pizzaRepository;
	}
	
	public SimpleOrderService(){}

	public void destroy(){
		System.out.println("Destroy simple order service");
	}

	@Autowired
	@Required
	public void setPizzaRepository(PizzaRepository pizzaRepository){
		this.pizzaRepository = pizzaRepository;
		System.out.println("pizza test method");
	}

	//@Override
	//public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	//	this.appContext = applicationContext;
	//}
}
