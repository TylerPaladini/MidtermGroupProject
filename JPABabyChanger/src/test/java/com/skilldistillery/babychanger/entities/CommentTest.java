package com.skilldistillery.babychanger.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommentTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Comment comment;
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
		comment = em.find(Comment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		comment = null;
	}

	@Test
	void test_comment_comment_mapping() {
		String expected = "test comment";
		assertEquals(expected, comment.getComment());
	}
	
	@Test
	void test_comment_user_mapping() {
		assertEquals("Jane", comment.getUser().getFirstName());
		assertEquals("Doe", comment.getUser().getLastName());
	}
	@Test
	void test_comment_restroom_mapping() {
		assertEquals("changing room w/showers", comment.getRestroom().getDescription());
		assertEquals("gound floor north tower east end down hallway", comment.getRestroom().getDirections());
	}
	
	@Test
	void test_comment_flagged_mapping() {
		assertEquals(null, comment.isFlagComment());
	}
	@Test
	void test_comment_active_mapping() {
		assertEquals(true, comment.isActive());
	}
	
	@Test
	void test_comment_rating_mapping() {
		assertEquals(Rating.ONE, comment.getRating());
	}
	
	@Test
	void test_comment_date_created_mapping() {
		assertEquals("2018-10-25 17:56:05.0", comment.getDateCreated().toString());
	}
	
	

}
