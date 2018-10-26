package com.skilldistillery.babychanger.data;

import java.util.Date;
import java.util.List;

import com.skilldistillery.babychanger.entities.Gender;
import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Rating;

public interface LocationDAO {

	public Location getLocationById(int id);
	
	public List<Location> getAllLocations();
	
	public Location createLocation(Location location);
	
	public boolean deleteLocation(int id);
	
	public boolean disableLocation(int id, Location location);
	
	public Location updateLocation(int id, Location location);
	
	public List<Location> getLocationsByCity(String city);
	
	public List<Location> getLocationsByState(String state);
	
	public List<Location> getLocationByKeyword(String keyword);
	
	public List<Location> getLocationLikeAddress(String addressLike);
	
	public List<Location> getLocationByGender(Gender gender);
	
	public List<Location> getLocationByName(String name);
	
	public List<Location> getLocationByZipCode(String zipCode);
	
	public List<Location> getLocationByRating(Rating rating); // 
	
	public List<Location> getLocationByFlag(Boolean flag);
	
	public List<Location> getLocationByOpen(Date open, Date close);
}
