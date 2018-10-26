package com.skilldistillery.babychanger.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddressTest {

	private static EntityManagerFactory emf;

	private EntityManager em;
	
	private Address address;

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
		address = em.find(Address.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@DisplayName("Test Address mappings")
	void test_address_mappings() {
		assertEquals("1210 Toledo St", address.getStreet());
		assertNull(address.getStreet2());
		assertEquals("Henderson", address.getCity());
		assertEquals("NV", address.getState());
		assertEquals("80918", address.getZipCode());
	}

}
