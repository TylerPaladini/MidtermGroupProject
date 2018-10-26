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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location createLocation(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteLocation(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disableLocation(int id, Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Location updateLocation(int id, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> getLocationsByState(String state) {
		// TODO Auto-generated method stub
		return null;
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
