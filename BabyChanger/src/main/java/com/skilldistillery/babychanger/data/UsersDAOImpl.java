package com.skilldistillery.babychanger.data;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Users;

@Transactional
@Repository
public class UsersDAOImpl implements UsersDAO {

	@PersistenceContext
	private EntityManager em;

	// Login the user

// Creates a new user
	@Override
	public Users createUsers(Users registerUserModel) {
		em.persist(registerUserModel);
		em.flush();
		if (registerUserModel.getId() == 0) {
			em.getTransaction().rollback();
			return null;
		} else {
			registerUserModel.setActive(true);
			return em.find(Users.class, registerUserModel.getId());
		}
	}

	// Updates current user
	@Override
	public Users updateUsers(int id, Users users) {
		Users updateUser = em.find(Users.class, id);

		if (updateUser != null) {
			updateUser.setFirstName(users.getFirstName());
			updateUser.setLastName(users.getLastName());
			updateUser.setEmail(users.getEmail());
			updateUser.setPassword(users.getPassword());
			updateUser.setUserName(users.getUserName());

		}
		return updateUser;

	}

//  Changes the user from active to inactive, does not delete from the database. 
	@Override
	public boolean disableUser(int id) {
		Users disableUser = em.find(Users.class, id);
		if (disableUser != null) {
			disableUser.setActive(false);
			return true;
		}
		return false;

	}
	@Override
	public boolean activateUser(int id) {
		Users disableUser = em.find(Users.class, id);
		if (disableUser != null) {
			disableUser.setActive(true);
			return true;
		}
		return false;
		
	}
	
	

	@Override
	public boolean giveUserAdminPower(int id) {
	Users disableUser = em.find(Users.class, id);
	if (disableUser != null) {
		disableUser.setAdmin(true);
		return true;
	}
	return false;
	}

	@Override
	public boolean takeAdminPowerFromUser(int id) {
		Users disableUser = em.find(Users.class, id);
		if (disableUser != null) {
			disableUser.setAdmin(false);
			return true;
		}
		return false;
	}

	//	Permanently deletes user from the database
	@Override
	public boolean deleteUsers(int id) {
		Users deleteUser = em.find(Users.class, id);

		em.remove(deleteUser);

		if (em.find(Users.class, id) != null) {
			em.getTransaction().rollback();
			return false;
		} else {
			return true;

		}

	}

	// List all the registered users
	@Override
	public List<Users> listAllUsers() {
		String query = "SELECT users FROM Users users";

		List<Users> allUsers = em.createQuery(query, Users.class).getResultList();
		return allUsers;
	}

	@Override
	public Users getUserByUsernameAndPassword(String userName, String password) {
		Users user = null;
		List<Users> allUsers = listAllUsers();
		for (Users checkUser : allUsers) {
			if (checkUser.getUserName().equals(userName) && checkUser.getPassword().equals(password)) {
				user = checkUser;
				break;
			}
		}
		return user;
	}

	@Override
	public boolean userDoesExist(String userName) {
		boolean userExist;
		String query = "SELECT COUNT(x.userName) FROM Users x WHERE x.userName = :userName";
		Long userCount = em.createQuery(query, Long.class).setParameter("userName", userName).getSingleResult();
		userExist = userCount == 0 ? false : true;
		return userExist;
	}

	@Override
	public boolean isUserActive(String userName) {
		String query = "SELECT x.active FROM Users x WHERE x.userName = :userName";
		List<Boolean> userActive = em.createQuery(query, Boolean.class).setParameter("userName", userName)
				.getResultList();

		boolean userActiveCheck = false;

		if (!userActive.isEmpty()) {
			Boolean userCheck = userActive.get(0);
			if (userCheck) {
				userActiveCheck = true;
			}
		}

		return userActiveCheck;
	}
	
	

	@Override
	public Users getUsersById(int id) {
		return em.find(Users.class, id);
	}

	@Override
	public List<Users> getUsersByFirstName(String firstName) {
		String query = "SELECT u FROM Users u where u.firstName like :fName";
		
		return em.createQuery(query, Users.class).setParameter("fName", "%" + firstName + "%").getResultList();
	}

	@Override
	public List<Users> getUsersByLastName(String lastName) {
		String query = "SELECT u FROM Users u where u.lastName like :lName";
		
		return em.createQuery(query, Users.class).setParameter("lName", "%" + lastName + "%").getResultList();
	}

	@Override
	public List<Users> getUsersByUsername(String username) {
		String query = "SELECT u FROM Users u where u.userName like :uName";
		return em.createQuery(query, Users.class).setParameter("uName", "%" + username + "%").getResultList();
	}

	@Override
	public List<Users> getUsersByEmail(String email) {
		String query = "SELECT u FROM Users u where u.email like :email";
		
		return em.createQuery(query, Users.class).setParameter("email", "%" + email + "%").getResultList();
	}

	@Override
	public Set<Users> usersByKeywords(String keywords) {
		String query = "SELECT u FROM Users u where u.email LIKE :email "
				+ " OR u.firstName LIKE :fName "
				+ " OR u.lastName LIKE :lName "
				+ " OR u.userName LIKE :uName";
		Set<Users> usersByKeyword = new HashSet<>();
		String[] words = keywords.trim().split("\\s+");
		for (String word : words) {
			usersByKeyword.addAll(em.createQuery(query,Users.class)
									.setParameter("email", "%" + word + "%")
									.setParameter("fName", "%" + word + "%")
									.setParameter("lName", "%" + word + "%")
									.setParameter("uName", "%" + word + "%")
									.getResultList()
								 );
			// old code
//			usersByKeyword.addAll(getUsersByFirstName(word));
//			usersByKeyword.addAll(getUsersByLastName(word));
//			usersByKeyword.addAll(getUsersByUsername(word));
//			usersByKeyword.addAll(getUsersByEmail(word));
		}
		return usersByKeyword;
	}
	
	
}
