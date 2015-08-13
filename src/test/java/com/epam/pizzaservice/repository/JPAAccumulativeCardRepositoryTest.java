package com.epam.pizzaservice.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.pizzaservice.domain.AccumulativeCard;
import com.epam.pizzaservice.repository.templetes.ITRepositoryTestsTemplete;

public class JPAAccumulativeCardRepositoryTest extends ITRepositoryTestsTemplete{
	
	@Autowired
	private AccumulativeCardRepository accumulativeCardRepository;
	
	@Ignore
	@Test
	public void AccumulativeCardRepository_testSaveMethod_NormalWork(){
		AccumulativeCard accumulativeCard = new AccumulativeCard();
		accumulativeCard.setAccumulativeSum(0);
		
		Long id = accumulativeCardRepository.save(accumulativeCard);
		System.out.println(id);
		assertNotNull(id);
		
	}
	
	@Ignore
	@Test
	public void AccumulativeCardRepository_testGetAccumulativeCardById_NormalWork(){
		AccumulativeCard accumulativeCard = accumulativeCardRepository.getAccumulativeCardById(1L);
		
		Long id = accumulativeCard.getId();
		System.out.println(id);
		assertNotNull(id);
		
	}
	
	@Ignore
	@Test
	public void AccumulativeCardRepository_testGetAccumulativeCardById_CardWithAddress_NormalWork(){
		AccumulativeCard accumulativeCard = accumulativeCardRepository.getAccumulativeCardById(2L);
		
		Long id = accumulativeCard.getAddress().getId();
		System.out.println(id);
		assertNotNull(id);
		
	}
}
