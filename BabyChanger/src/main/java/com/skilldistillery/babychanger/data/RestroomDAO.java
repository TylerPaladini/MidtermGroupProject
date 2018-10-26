package com.skilldistillery.babychanger.data;

import com.skilldistillery.babychanger.entities.Restroom;

public interface RestroomDAO {
	public Restroom getRestroom(int id);
	public Restroom create(Restroom restroom);
	public Restroom update(int id, Restroom restroom); 
	public boolean destroy(int id);
}
