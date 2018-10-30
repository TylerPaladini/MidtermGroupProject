package com.skilldistillery.babychanger.data;

import com.skilldistillery.babychanger.entities.Restroom;

public interface RestroomDAO {
	public Restroom getRestroom(int id);
	public Restroom createRestroom(Restroom restroom);
	public Restroom updateRestroom(int id, Restroom restroom); 
	public boolean destroyRestroom(int id);
	public boolean disableRestroom(int id, Restroom restroom);
	boolean updateFlag(int id, boolean isFlag);
}
