package com.epam.pizzaservice.domain;

import java.util.List;

public class Order {
	private Integer id;
	private List<Pizza> list;
	private Customer customer;
	
	public Order() {}
	
	public Order(Customer customer, List<Pizza> list) {
		this.list = list;
		this.customer = customer;
	}
	public Order(Integer id, List<Pizza> list, Customer customer) {
		this.id = id;
		this.list = list;
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", list=" + list + ", customer=" + customer
				+ "]";
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
	
	

}
