package com.epam.pizzaservice.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class AccumulativeCard {
	//@Id
	//@GeneratedValue
	private Integer id;
	//@Embedded
	private Address address;
	//@Column(name="acc_sum")
	private Integer accumulativeSum;
	
	public AccumulativeCard() {
	}

	public AccumulativeCard(Integer id, Address address, Integer accumulativeSum) {
		this.id = id;
		this.address = address;
		this.accumulativeSum = accumulativeSum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getAccumulativeSum() {
		return accumulativeSum;
	}

	public void setAccumulativeSum(Integer accumulativeSum) {
		this.accumulativeSum = accumulativeSum;
	}
}
