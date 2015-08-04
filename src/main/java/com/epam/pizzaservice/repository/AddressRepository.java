package com.epam.pizzaservice.repository;

import com.epam.pizzaservice.domain.Address;

public interface AddressRepository {
	Address getAddressById(Integer id);
}
