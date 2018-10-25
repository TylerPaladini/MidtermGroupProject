package com.skilldistillery.babychanger.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressTest {

	private EntityManagerFactory emf;

	private EntityManager em;

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
	
	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("babychangerdb");
		em = emf.createEntityManager();
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	void test_address_mappings() {
		Location location = em.find(Location.class, 1);
		assertEquals("1210 Toledo St", location.getAddress()); 
	}

}
