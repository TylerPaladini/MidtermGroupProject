package com.skilldistillery.babychanger.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.babychanger.entities.Users;

@Transactional
@Repository
public class UsersDAOImpl implements UsersDAO {
	
	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("babychangerdb");

	@PersistenceContext
	private EntityManager em;

// Creates a new user
	@Override
	public Users createUsers(Users users) {
		em = emf.createEntityManager();
		em.persist(users);
		em.flush();
		if (users.getId() == 0) {
			em.getTransaction().rollback();
			return null;
		} else {
			return em.find(Users.class, users.getId());
		}
	}

	// Updates current user
	@Override
	public Users updateUsers(int id, Users users) {
		em = emf.createEntityManager();
		Users updateUser = em.find(Users.class, id);

		if (updateUser != null) {
			updateUser.setFirstName(users.getFirstName());
			updateUser.setLastName(users.getLastName());
			updateUser.setEmail(users.getEmail());
			updateUser.setPassword(users.getPassword());

		}
		return updateUser;
	}
//  Changes the user from active to inactive, does not delete from the database. 
	@Override
	public boolean disableUser(int id, Users users) {
		em = emf.createEntityManager();
		Users disableUser = em.find(Users.class, id);

		if (disableUser != null) {
			disableUser.setActive(false);
		}
		return false;

	}

//	Permanently deletes user from the database
	@Override
	public boolean deleteUsers(int id, Users users) {
		em = emf.createEntityManager();
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
		em = emf.createEntityManager();
		String query = "SELECT users FROM Users users";
		
		List<Users> allUsers = em.createQuery(query, Users.class).getResultList();
		return allUsers;
	}
}
