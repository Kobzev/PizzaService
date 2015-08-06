package com.epam.pizzaservice.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AccumulativeCard {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_address", nullable=true)
	private Address address;
	@Column(name="acc_sum")
	private Integer accumulativeSum;
	
	public AccumulativeCard() {
	}

	public AccumulativeCard(Long id, Address address, Integer accumulativeSum) {
		this.id = id;
		this.address = address;
		this.accumulativeSum = accumulativeSum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
