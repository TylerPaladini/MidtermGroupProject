package com.skilldistillery.babychanger.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Location location;
	
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
		location = em.find(Location.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	@DisplayName("Test mappings for location entity")
	void test_location_mappings() {
		assertEquals("Solarium", location.getName());
		assertEquals("Henderson", location.getAddress().getCity());
		assertEquals("have to be a student", location.getAccessLimits());
		assertEquals(false, location.isPurchaseRequired());
		assertEquals("7194406626", location.getPhone());
		assertEquals("08:00:00", location.getOpenTime().toString());
		assertEquals("18:00:00", location.getCloseTime().toString());
	}
	
	@Test
	@DisplayName("Confirm list restroom")
	void test_add_remove_restroom_list() {
		assertEquals(2, location.getRestrooms().size());
		Restroom restroom = new Restroom();
		restroom.setChangingTable(true);
		restroom.setUserId(1);
		location.addRestroom(restroom);
		assertEquals(3, location.getRestrooms().size());
		location.removeRestroom(restroom);
		assertEquals(2, location.getRestrooms().size());
	}
}
