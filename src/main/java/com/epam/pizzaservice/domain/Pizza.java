package com.epam.pizzaservice.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pizza {
	@Id
	private Integer id;
	private String name;
	private Double price;
	private PizzaType type;
	
	@OneToMany(mappedBy = "pizza")
	private List<Pizza_Order> pizzaOrder;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public PizzaType getType() {
		return type;
	}
	public void setType(PizzaType type) {
		this.type = type;
	}
	public Pizza(Integer id, String name, Double price, PizzaType type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public Pizza() {
		super();
	}
	
	
	
	

}
