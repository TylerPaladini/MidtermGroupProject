package com.skilldistillery.babychanger.data;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.babychanger.entities.Location;
import com.skilldistillery.babychanger.entities.Restroom;

public class RestroomDAOtest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
//	private Restroom restroom;
	
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
	@DisplayName("Get a RR")
	void test_DAO_get_RR() {
		RestroomDAOImpl bagno = new RestroomDAOImpl(); 
		bagno.getRestroom(1); 
		System.out.println(bagno);

	}
	
//	@Test
//	@DisplayName("Test RR add DAO")
//	void test_restroom_DAO_add_a_restroom() { 
////		Restroom bano = new Restroom(); 
//		RestroomDAOImpl bagno = new RestroomDAOImpl(); 
//		
//		Location location = new Location(); 
//		em.find(Location.class, 1);
//		
//		bagno.setChangingTable(false);
//		bagno.setDescription("test");
//		bagno.setLocation(bagno.getLocation());
//		bagno.setUserId(4);
//		
//		location.addRestroom(bagno);
//
//		assertEquals(false, bagno.getChangingTable()); 
//	}
	
	
}
