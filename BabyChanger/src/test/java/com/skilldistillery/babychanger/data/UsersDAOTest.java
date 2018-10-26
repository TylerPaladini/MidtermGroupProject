package com.skilldistillery.babychanger.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.babychanger.entities.Users;

class UsersDAOTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	UsersDAOImpl usersDAO = new UsersDAOImpl();
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("babychangerdb");
	}
	
	@AfterAll
	static void tearDownAll() throws Exception {
		emf.close();
		
	}



	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		usersDAO = null;
		
	}

	@Test
	@DisplayName("Tests all users can be listed")
	void test() {
		
		List<Users> allUsers = usersDAO.listAllUsers();
		
		assertEquals(3,allUsers.size());
		
	}

}
