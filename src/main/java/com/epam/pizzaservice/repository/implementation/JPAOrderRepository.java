package com.epam.pizzaservice.repository.implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.epam.pizzaservice.domain.Order;
import com.epam.pizzaservice.domain.OrderDTO;
import com.epam.pizzaservice.repository.OrderRepository;

@Repository("orderRepository")
public class JPAOrderRepository implements OrderRepository {
	
	@PersistenceContext(name = "HiberanteMySQL")
	private EntityManager em;

	@Override
	public void saveOrder(Order newOrder) {
		save(newOrder);
	}

	@Override
	public Order getOrderById(Long id) {
		TypedQuery<OrderDTO> query = em.createQuery("select p from OrderDTO p where p.id = :id", OrderDTO.class);
		query.setParameter("id", id);
		Order order = new Order(query.getSingleResult());
		return order;
	}

	@Override
	@Transactional
	public Long save(Order order) {
		if (order == null)
			return null;
		
		OrderDTO orderDTO = new OrderDTO(order);

		if (orderDTO.getId() == null) {
			em.persist(orderDTO);
		} else {
			em.merge(orderDTO);
		}
		order.setId(orderDTO.getId());
		return order.getId();
		//return 1L;
	}

}
