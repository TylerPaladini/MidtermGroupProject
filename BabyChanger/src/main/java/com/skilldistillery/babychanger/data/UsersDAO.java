package com.skilldistillery.babychanger.data;

import java.util.List;

import com.skilldistillery.babychanger.entities.Users;

public interface UsersDAO {
	
	public Users createUsers(Users users);
	
	public Users updateUsers(int id, Users users);
	
	public boolean disableUser(int id, Users users);
	
	public boolean deleteUsers(int id, Users users);
	
	public List<Users> listAllUsers ();
	
	
	

}
