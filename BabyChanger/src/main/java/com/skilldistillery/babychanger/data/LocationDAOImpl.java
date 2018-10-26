package com.skilldistillery.babychanger.data;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.babychanger.entities.Gender;
import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Rating;

@Transactional
@Repository
public class LocationDAOImpl implements LocationDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Location getLocationById(int id) {
		Location getLocation = em.find(Location.class, id);
		return getLocation;
	}

	@Override
	public List<Location> getAllLocations() {
		String query = "SELECT location FROM Location location";
		List<Location> locationList = em.createQuery(query, Location.class).getResultList();
		return locationList;
	}

	@Override
	public Location createLocation(Location location) {
		em.persist(location);
		em.flush();
		if(location.getId() == 0) {
			em.getTransaction().rollback();
		}
		return location;
	}

	@Override
	public boolean deleteLocation(int id) {
		boolean destroyed;
		Location toDestroy = em.find(Location.class, id);
		em.remove(toDestroy);
		if(em.contains(toDestroy)) {
			destroyed = false;
			em.getTransaction().rollback();
		} else {
			destroyed = true;
		}
		return destroyed;
	}

	@Override
	public Location updateLocation(int id, Location location) {
		Location updateLocation = em.find(Location.class, id);
		if(updateLocation != null) {
			updateLocation.setName(location.getName());
			updateLocation.setAccessLimits(location.getAccessLimits());
			updateLocation.setPurchaseRequired(location.isPurchaseRequired());
			updateLocation.setPhone(location.getPhone());
			updateLocation.setOpenTime(location.getOpenTime());
			updateLocation.setCloseTime(location.getCloseTime());
			updateLocation.setAddress(location.getAddress());
			updateLocation.setDateCreated(location.getDateCreated());
		}
		return updateLocation;
	}

	@Override
	public List<Location> getLocationsByCity(String city) {
		String query = "SELECT location FROM Location location WHERE location.address.city IS LIKE :city";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("city", city)
											.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByState(String state) {
		String query = "SELECT location FROM Location location WHERE location.address.state IS LIKE :state";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("state", state)
											.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationLikeAddress(String addressLike) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationByGender(Gender gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationByZipCode(String zipCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationByRating(Rating rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationByFlag(Boolean flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationByOpen(Date open, Date close) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
