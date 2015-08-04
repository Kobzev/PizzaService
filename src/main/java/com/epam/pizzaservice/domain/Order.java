package com.epam.pizzaservice.domain;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "order")
@Scope(value="prototype")
public class Order {
	static int count;
	
	private Integer id;
	private String name;
	private List<Pizza> list;
	private Customer customer;
	
	Map<Pizza, Integer> pizzaMap;
	
	public Order() {
		id = count++;
		name = id.toString();
	}
	
	public Order(Customer customer, List<Pizza> list) {
		this.list = list;
		this.customer = customer;
	}
	public Order(Integer id, List<Pizza> list, Customer customer) {
		this.id = id;
		this.list = list;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", list=" + list + ", customer=" + customer
				+ "]";
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Pizza> getList() {
		return list;
	}
	public void setList(List<Pizza> list) {
		this.list = list;
	}
	
	public Map<Pizza, Integer> getPizzaMap() {
		return pizzaMap;
	}

	public void setPizzaMap(Map<Pizza, Integer> pizzaMap) {
		this.pizzaMap = pizzaMap;
	}

	public void destroy(){
		System.out.println("destroy");
	}

}
