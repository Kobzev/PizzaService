package com.rd.pizzaservice.infostructure;

import java.util.HashMap;
import java.util.Map;

import com.rd.pizzaservice.repository.implementation.TestOrderRepository;
import com.rd.pizzaservice.repository.implementation.TestPizzaRepository;
import com.rd.pizzaservice.service.implementation.SimpleOrderService;

public class JavaConfig implements Config{
	private Map<String,Class<?>> map = new HashMap<>();
	
	{
		map.put("orderRepository", TestOrderRepository.class);
		map.put("pizzaRepository", TestPizzaRepository.class);
		map.put("orderService", SimpleOrderService.class);
	}

	@Override
	public Class<?> getImplementation(String beanName) {
		return map.get(beanName);
	}

}
