package com.epam.pizzaservice.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Order {
	static int count;
	
	@Id
	private Integer id;
	private String name;
	private List<Pizza> list;
	private Customer customer;
	
	@OneToMany(mappedBy = "order")
	private List<Pizza_Order> pizzaOrder;
	
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
	
	public void destroy(){
		System.out.println("destroy");
	}

}
