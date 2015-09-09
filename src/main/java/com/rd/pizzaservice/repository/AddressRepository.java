package com.rd.pizzaservice.repository;

import com.rd.pizzaservice.domain.Address;

public interface AddressRepository {
	Address getAddressById(Long id);
	Long save(Address address);
}
