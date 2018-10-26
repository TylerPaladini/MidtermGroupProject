package com.skilldistillery.babychanger.entities;

import static org.junit.Assert.assertEquals;

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

class RestroomTest {

	private static EntityManagerFactory emf;

	private EntityManager em;
	
	private Restroom restroom;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	emf = Persistence.createEntityManagerFactory("babychangerdb");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}
	
	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	@DisplayName("Test Restroom mappings")
	void test_restroom_mappings() { 
		restroom = em.find(Restroom.class, 1); 
		assertEquals(Gender.M, restroom.getGender());
		assertEquals(false, restroom.getChangingTable()); 
		assertEquals("changing room w/showers", restroom.getDescription()); 
	}
	
	@Test
	@DisplayName("Test comments") 
	void test_comments() {
		
		restroom = em.find(Restroom.class, 1); 
		
		assertEquals("test another comment", restroom.getComments().get(1).getComment());
		assertEquals(2, restroom.getComments().size());
		
		Comment newComment = new Comment(); 
		newComment.setUser(em.find(Users.class, 1));
		newComment.setComment("test comment 3");
		newComment.setDateCreated(java.sql.Date.valueOf("2018-10-25"));
		
		restroom.addComment(newComment);
		
		assertEquals(3, restroom.getComments().size()); 
		assertEquals("test comment 3", restroom.getComments().get(2).getComment());
		
		restroom.removeComment(newComment);
		assertEquals(2, restroom.getComments().size()); 
	}	
}
