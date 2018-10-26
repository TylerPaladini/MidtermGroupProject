package com.skilldistillery.babychanger.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("babychangerdb");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	@DisplayName("tests Users connects to the database")
	void test() {
		Users user = em.find(Users.class, 1);
		assertEquals("Jane", user.getFirstName());
		assertEquals("Doe", user.getLastName());
		assertEquals("janedoe", user.getUserName());
		assertEquals("janedoe@gmail.com", user.getEmail());
		assertEquals(true, user.isActive());
		assertEquals(null, user.getDateCreated());
	}
	
	@Test
	@DisplayName("test one to many with comments")
	void test2() {
		Comment comment = em.find(Comment.class, 1);
		assertEquals("test comment", comment.getComment());
		
		
		Users users = em.find(Users.class, 1);
		assertEquals(2, users.getComments().size());
		Comment comm = new Comment();
		comm.setUser(em.find(Users.class, 2));
		comm.setRestroom(em.find(Restroom.class, 1));
		comm.setDateCreated(java.sql.Date.valueOf("2018-10-26"));
		users.addComment(comm);
		assertEquals(3, users.getComments().size());
		users.removeComment(comm);
		assertEquals(2, users.getComments().size());
		
		
		
		
	}

}
