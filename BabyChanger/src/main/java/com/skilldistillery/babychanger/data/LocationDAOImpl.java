package com.skilldistillery.babychanger.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class LocationDAOImpl implements LocationDAO{

	@PersistenceContext
	private EntityManager em;
	
	
}
