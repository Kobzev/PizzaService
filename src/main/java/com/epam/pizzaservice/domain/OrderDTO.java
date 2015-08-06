package com.epam.pizzaservice.domain;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;


@Entity @Table(name="orders")
public class OrderDTO {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_customer", nullable=true)
	private Customer customer;
		
	//@ManyToMany
	@ElementCollection
	@CollectionTable(name="order_pizza",
			joinColumns=@JoinColumn(name="id_order"))
	//@JoinTable(name="order_pizza",
	// joinColumns=@JoinColumn(name="id_order"),
	// inverseJoinColumns=@JoinColumn(name="id_pizza"))
	@MapKeyJoinColumn(name="id_pizza")
	@Column(name="amount")
	private Map<Pizza, Integer> pizzaMap;
	
	public OrderDTO(){}
	
	public OrderDTO(Order order){
		this.id	  = order.getId();
		this.name = order.getName();
	}

	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Map<Pizza, Integer> getPizzaMap() {
		return pizzaMap;
	}

	public String getName() {
		return name;
	}
}
