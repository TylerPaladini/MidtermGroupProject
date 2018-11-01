package com.skilldistillery.babychanger.data;

import java.util.List;
import java.util.Set;

import com.skilldistillery.babychanger.entities.Address;
import com.skilldistillery.babychanger.entities.Gender;
import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Rating;

public interface LocationDAO {

	public Location getLocationById(int id);
	
	public List<Location> getAllLocations();
	
	public Location createLocation(Location location);
	
	public boolean deleteLocation(int id);
	
	public Location updateLocation(int locationId, Location location, Address address);
	
	public List<Location> getLocationsByCity(String city);
	
	public List<Location> getLocationsByState(String state);
	
	public Set<Location> getLocationsByKeyword(String keyword);
	
	public List<Location> getLocationsLikeAddress(String addressLike);
	
	public List<Location> getLocationsByGender(Gender gender);
	
	public List<Location> getLocationsByName(String name);
	
	public List<Location> getLocationsByZipCode(String zipCode);
	
	public List<Location> getLocationsByRating(Rating rating);
	
	public List<Location> getLocationsByFlag(Boolean flag);
	
	public List<Location> getLocationsByOpen();
	
	public Double getAverageRating(int id);
	
}
