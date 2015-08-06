package com.epam.pizzaservice.repository;

import com.epam.pizzaservice.domain.AccumulativeCard;

public interface AccumulativeCardRepository {
	AccumulativeCard getAccumulativeCardById(Long id);
	Long save(AccumulativeCard accumulativeCard);
}
