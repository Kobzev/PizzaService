package com.epam.pizzaservice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Pizza_Order {
	
	@Id
	private Integer orderId;
	@Id
	private Integer pizzaId;

	private Integer amount;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "ORDERID", referencedColumnName = "ID")
	/*
	 * if this JPA model doesn't create a table for the "PROJ_EMP" entity,
	 * please comment out the @PrimaryKeyJoinColumn, and use the ff:
	 * 
	 * @JoinColumn(name = "orderId", updatable = false, insertable = false)
	 * or @JoinColumn(name = "orderId", updatable = false, insertable =
	 * false, referencedColumnName = "id")
	 */
	private Order order;

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "PIZZAID", referencedColumnName = "ID")
	/*
	 * if this JPA model doesn't create a table for the "PROJ_EMP" entity,
	 * please comment out the @PrimaryKeyJoinColumn, and use the ff:
	 * 
	 * @JoinColumn(name = "pizzaId", updatable = false, insertable = false)
	 * or @JoinColumn(name = "pizzaId", updatable = false, insertable =
	 * false, referencedColumnName = "id")
	 */
	private Pizza pizza;

	// @ManyToMany
	// @JoinTable(name = "EMP_PROJ", joinColumns = {
	// @JoinColumn(name = "EMP_ID", referencedColumnName = "ID") },
	// inverseJoinColumns = {
	// @JoinColumn(name = "PROJ_ID", referencedColumnName = "ID") })

}
