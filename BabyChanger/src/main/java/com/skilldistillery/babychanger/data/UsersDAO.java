package com.skilldistillery.babychanger.data;

import java.util.List;
import java.util.Set;

import com.skilldistillery.babychanger.entities.Users;

public interface UsersDAO {
	
	public Users createUsers(Users users);
	
	public Users updateUsers(int id, Users users);
	
	public boolean disableUser(int id);
	
	public boolean deleteUsers(int id);
	
	public List<Users> listAllUsers ();
	
	public Users getUserByUsernameAndPassword(String userName, String password);

	public boolean userDoesExist(String userName);
	
	public boolean isUserActive(String userName);
	
	public Users getUsersById(int id);
	public List<Users> getUsersByFirstName(String firstName);
	public List<Users> getUsersByLastName(String lastName);
	public List<Users> getUsersByUsername(String username);
	public List<Users> getUsersByEmail(String email);
	
	public Set<Users> usersByKeywords(String keywords);
}
