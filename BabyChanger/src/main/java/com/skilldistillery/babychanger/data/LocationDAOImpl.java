package com.skilldistillery.babychanger.data;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.babychanger.entities.Address;
import com.skilldistillery.babychanger.entities.Gender;
import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Rating;

@Transactional
@Repository
public class LocationDAOImpl implements LocationDAO {

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
		if (location.getId() == 0) {
			em.getTransaction().rollback();
		}
		return location;
	}

	@Override
	public boolean deleteLocation(int id) {
		boolean destroyed;
		Location toDestroy = em.find(Location.class, id);
		em.remove(toDestroy);
		if (em.contains(toDestroy)) {
			destroyed = false;
			em.getTransaction().rollback();
		} else {
			destroyed = true;
		}
		return destroyed;
	}

	@Override
	public Location updateLocation(int locationId, Location location, Address address) {
		Location updateLocation = em.find(Location.class, locationId);
		if (updateLocation != null) {
			updateLocation.setName(location.getName());
			updateLocation.setAccessLimits(location.getAccessLimits());
			updateLocation.setPurchaseRequired(location.isPurchaseRequired());
			updateLocation.setPhone(location.getPhone());
//			updateLocation.setOpenTime(location.getOpenTime().toString().substring(0, 5));
//			updateLocation.setCloseTime(location.getCloseTime().toString().substring(0, 5));
			updateLocation.setOpenTime(location.getOpenTime());
			updateLocation.setCloseTime(location.getCloseTime());
			updateLocation.getAddress().setStreet(address.getStreet());
			updateLocation.getAddress().setStreet2(address.getStreet2());
			updateLocation.getAddress().setCity(address.getCity());
			updateLocation.getAddress().setState(address.getState());
			updateLocation.getAddress().setZipCode(address.getZipCode());
		}
		return updateLocation;
	}

	@Override
	public List<Location> getLocationsByCity(String city) {
		String query = "SELECT location FROM Location location WHERE location.address.city LIKE :city";
		List<Location> locationByCity = em.createQuery(query, Location.class).setParameter("city", "%" + city + "%")
				.getResultList();
		System.out.println(locationByCity);
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByState(String state) {
//						SELECT location FROM Location location JOIN Address address ON address.id = location.address_id WHERE state LIKE 'CO';
		String query = "SELECT location FROM Location location WHERE location.address.state LIKE :state ";
		List<Location> locationByCity = em.createQuery(query, Location.class).setParameter("state", "%" + state + "%")
				.getResultList();
		return locationByCity;
	}

	@Override
	public Set<Location> getLocationsByKeyword(String keyword) {
		String query = "SELECT location FROM Location location WHERE location.address.state LIKE :state "
				+ " OR location.name LIKE :name "
				+ " OR location.address.street LIKE :street "
				+ " OR location.address.street2 LIKE :street2 "
				+ " OR location.address.city LIKE :city "
				+ " OR location.address.zipCode LIKE :zip ";
		Set<Location> locationByKeyword = new HashSet<>();
		String[] keywords = keyword.trim().split("\\s+");
		
		for (String word : keywords) {
			locationByKeyword.addAll(em.createQuery(query, Location.class)
									   .setParameter("state","%" + word + "%")
									   .setParameter("name", "%" +word  + "%")
									   .setParameter("street", "%" +word  + "%")
									   .setParameter("street2","%" + word  + "%")
									   .setParameter("city","%" + word  + "%")
									   .setParameter("zip", "%" +word  + "%")
									   .getResultList()
									);
			// old code
//			locationByKeyword.addAll(getLocationsByName(word));
//			locationByKeyword.addAll(getLocationsLikeAddress(word));
//			locationByKeyword.addAll(getLocationsByCity(word));
//			locationByKeyword.addAll(getLocationsByState(word));
//			locationByKeyword.addAll(getLocationsByZipCode(word));
		

		}
		return locationByKeyword;
	}

	@Override
	public List<Location> getLocationsLikeAddress(String addressLike) {
		String query = "SELECT location FROM Location location WHERE location.address.street LIKE :address";
		List<Location> locationByAddress = em.createQuery(query, Location.class)
				.setParameter("address", "%" + addressLike + "%").getResultList();
		return locationByAddress;
	}

	@Override
	public List<Location> getLocationsByGender(Gender gender) {
		String query = "SELECT location FROM Location location WHERE location.restroom.gender = :gender";
		List<Location> locationByCity = em.createQuery(query, Location.class).setParameter("gender", gender)
				.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByName(String name) {
		String query = "SELECT location FROM Location location WHERE location.name LIKE :name ";
		List<Location> locationByCity = em.createQuery(query, Location.class).setParameter("name", "%" + name + "%")
				.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByZipCode(String zipCode) {
		String query = "SELECT location FROM Location location WHERE location.address.zipCode LIKE :zipCode";
		List<Location> locationByCity = em.createQuery(query, Location.class)
				.setParameter("zipCode", "%" + zipCode + "%").getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByRating(Rating rating) {
		String query = "SELECT location FROM Location location WHERE location.restroom.rating = :rating";
		List<Location> locationByCity = em.createQuery(query, Location.class).setParameter("rating", rating)
				.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByFlag(Boolean flag) {
		String query = "SELECT location FROM Location location WHERE location.restroom.flagged = :flagged";
		List<Location> locationByCity = em.createQuery(query, Location.class).setParameter("flagged", flag)
				.getResultList();
		return locationByCity;
	}

	@Override
	public List<Location> getLocationsByOpen() {
		String query = "SELECT location FROM Location location Join fetch location.restrooms WHERE location.openTime < CURRENT_TIME() AND location.closeTime > CURRENT_TIME()";
		List<Location> locationList = em.createQuery(query, Location.class).getResultList();
		
		//nasty way to ensure no duplicates. needs refactoring
		Set<Location> locationSet = new HashSet<>();
		locationSet.addAll(locationList);
		locationList.clear();
		locationList.addAll(locationSet);
		
		return locationList;
	}

	@Override
	public Double getAverageRating(int id) {
		String query = "select avg(c.rating) from Comment c where c.restroom.location.id = :id AND c.active = true";
		
		Double averageRating = em.createQuery(query, Double.class).setParameter("id", id).getSingleResult();
		return averageRating;
	}
	
	

//	********* We went form this code to the code above *********
//	@Override
//	public List<Location> getLocationsByOpen() {
//		List<Location> locationOpenList = null;
//		String query = "SELECT DISTINCT location FROM Location location JOIN FETCH location.restrooms";
//										.setParameter("open", LocalDateTime.now())
//										.setParameter("close", LocalDateTime.now())
//		for (Location locationCheck : locationList) {
//			if ((locationCheck.getOpenTime() != null && locationCheck.getCloseTime() != null)) {
//				if (locationCheck.getOpenTime().toLocalTime().isBefore(LocalTime.now())
//						&& locationCheck.getCloseTime().toLocalTime().isAfter(LocalTime.now())) {
//					if (locationOpenList == null) {
//						locationOpenList = new ArrayList<>();
//					}
//					locationOpenList.add(locationCheck);
//				}
//			}
//		}
//		return locationOpenList;
//	}

}
