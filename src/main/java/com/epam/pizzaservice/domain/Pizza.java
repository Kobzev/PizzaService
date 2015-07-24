package com.epam.pizzaservice.domain;


public class Pizza {
	private Integer id;
	private String name;
	private Double price;
	private PizzaType type;
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
