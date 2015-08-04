package com.epam.pizzaservice.domain;

public class AccumulativeCard {
	private Integer id;
	private Address address;
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
