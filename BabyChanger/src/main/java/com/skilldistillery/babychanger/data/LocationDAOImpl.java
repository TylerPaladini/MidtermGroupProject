package com.skilldistillery.babychanger.data;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		String query = "SELECT location FROM Location location WHERE location.address.city LIKE :city";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("city", "%" + city + "%")
											.getResultList();
		System.out.println(locationByCity);
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByState(String state) {
//						SELECT location FROM Location location JOIN Address address ON address.id = location.address_id WHERE state LIKE 'CO';
		String query = "SELECT location FROM Location location WHERE location.address.state LIKE :state ";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("state", "%" + state + "%")
											.getResultList();
		return locationByCity;
	}

	@Override
	public Set<Location> getLocationsByKeyword(String keyword) {
		Set<Location> locationByKeyword = new HashSet<>();
		String[] keywords = keyword.trim().split("\\s+");
		for (String keywordList : keywords) {
			locationByKeyword.addAll(getLocationsByCity(keywordList));
			locationByKeyword.addAll(getLocationsByState(keywordList));
			locationByKeyword.addAll(getLocationsLikeAddress(keywordList));
			locationByKeyword.addAll(getLocationsByName(keywordList));
			locationByKeyword.addAll(getLocationsByZipCode(keywordList));
		}
		return locationByKeyword;
	}

	@Override
	public List<Location> getLocationsLikeAddress(String addressLike) {
		String query = "SELECT location FROM Location location WHERE location.address.street LIKE :address";
		List<Location> locationByAddress = em.createQuery(query, Location.class)
											.setParameter("address", "%" + addressLike + "%")
											.getResultList();
		return locationByAddress;
	}

	@Override
	public List<Location> getLocationsByGender(Gender gender) {
		String query = "SELECT location FROM Location location WHERE location.restroom.gender = :gender";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("gender", gender)
											.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByName(String name) {
		String query = "SELECT location FROM Location location WHERE location.name LIKE :name ";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("name", "%" + name + "%")
											.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByZipCode(String zipCode) {
		String query = "SELECT location FROM Location location WHERE location.address.zipCode LIKE :zipCode";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("zipCode", "%" + zipCode + "%")
											.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByRating(Rating rating) {
		String query = "SELECT location FROM Location location WHERE location.restroom.rating = :rating";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("rating", rating)
											.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByFlag(Boolean flag) {
		String query = "SELECT location FROM Location location WHERE location.restroom.flagged = :flagged";
		List<Location> locationByCity = em.createQuery(query, Location.class)
											.setParameter("flagged", flag)
											.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByOpen() {
		String query = "SELECT location FROM Location location WHERE location.openTime < :time AND location.closeTime > :time";
		List<Location> locationOpen = em.createQuery(query, Location.class)
										.setParameter("open", LocalTime.now())
										.setParameter("close", LocalTime.now())
										.getResultList();
		return locationOpen;
	}
	
	
}
