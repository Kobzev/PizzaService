package com.epam.pizzaservice.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.epam.pizzaservice.domain.Pizza;
import com.epam.pizzaservice.repository.PizzaRepository;

@Repository("pizzaRepository")
public class JPAPizzaRepository implements PizzaRepository {

	@PersistenceContext(name = "HiberanteMySQL")
	private EntityManager em;
	
	@Override
	public List<Pizza> getAllPizzas() {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		return query.getResultList();
		
	}
	
	@Override
	public Pizza getPizzaByID(Long id) {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.id = :id", Pizza.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Long save(Pizza pizza) {
		if (pizza == null) return null;
		
		if (pizza.getId() == null) {
			em.persist(pizza);
		}else {
			em.merge(pizza);
		}
		return pizza.getId();
	}

}
