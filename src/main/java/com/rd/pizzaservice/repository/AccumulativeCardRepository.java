package com.rd.pizzaservice.repository;

import com.rd.pizzaservice.domain.AccumulativeCard;

public interface AccumulativeCardRepository {
	AccumulativeCard getAccumulativeCardById(Long id);
	Long save(AccumulativeCard accumulativeCard);
}
