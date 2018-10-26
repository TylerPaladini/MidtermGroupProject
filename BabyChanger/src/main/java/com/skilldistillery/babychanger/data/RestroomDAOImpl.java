package com.skilldistillery.babychanger.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.babychanger.entities.Restroom;

@Transactional
@Repository
public class RestroomDAOImpl implements RestroomDAO {
	
	@PersistenceContext
	
	private EntityManager em;
	
	@Override
	public Restroom getRestroom(int id) {
		Restroom restroom = null; 
		
		String jpql = "Select r from Restroom where id= :id"; 
		
		restroom = em.createQuery(jpql, Restroom.class).setParameter("id", id).getSingleResult();
		
		return restroom;
	}

	@Override
	public Restroom create(Restroom restroom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restroom update(int id, Restroom restroom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
