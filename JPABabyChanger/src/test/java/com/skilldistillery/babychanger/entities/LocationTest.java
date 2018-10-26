package com.skilldistillery.babychanger.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	void test() {
		assertEquals("Solarium", location.getName());
		assertEquals("have to be a student", location.getAccessLimits());
		assertEquals(false, location.isPurchaseRequired());
		assertEquals("7194406626", location.getPhone());
//		LocalDate date = location.getOpenTime();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ISO_LOCAL_TIME");
//		String text = Integer.toString(location.getOpenTime().getHours());
//		String text = date.format(formatter);
		
		
		assertEquals("08:00:00", location.getOpenTime());
	}

}
