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
		
		String jpql = "Select r from Restroom r where id = :id"; 
		
		restroom = em.createQuery(jpql, Restroom.class).setParameter("id", id).getSingleResult();
		
		return restroom;
	}

	@Override
	public Restroom createRestroom(Restroom restroom) {
		em.persist(restroom);
		em.flush();
		return restroom;
	}

	@Override
	public Restroom updateRestroom(int id, Restroom updatedRR) {
		Restroom restroom = em.find(Restroom.class, id); 
		
		restroom.setLocation(updatedRR.getLocation());
		restroom.setPicture(updatedRR.getPicture());
		restroom.setFlagged(updatedRR.getFlagged());
		restroom.setFlaggedDate(updatedRR.getFlaggedDate());
		restroom.setFlaggedReason(updatedRR.getFlaggedReason());
		restroom.setGender(updatedRR.getGender());
		restroom.setDirections(updatedRR.getDirections());
		restroom.setpAccess(updatedRR.getpAccess());
		restroom.setUserId(updatedRR.getUserId());
		restroom.setDateCreated(updatedRR.getDateCreated());
		restroom.setDescription(updatedRR.getDescription());
		restroom.setChangingTable(updatedRR.getChangingTable());
		
		return restroom;
	}

	@Override
	public boolean destroyRestroom(int id) {
		Restroom restroom = em.find(Restroom.class, id);
		em.remove(restroom);
		return true;
	}
	
	@Override
	public boolean disableRestroom(int id, Restroom restroom) {
		Restroom toDisable = em.find(Restroom.class, id);
		boolean disabled = false;
		if(toDisable != null) {
			toDisable.setFlagged(true);
			disabled = true;
		}
		return disabled;
	}

}
