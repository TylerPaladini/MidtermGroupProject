package com.skilldistillery.babychanger.data;

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

import com.skilldistillery.babychanger.entities.Address;

class AddressDAOTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Address address;
	
	private AddressDAOImpl addressDAO = new AddressDAOImpl();

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
		address = new Address();
		address.setStreet("1234 Test Street");
		address.setStreet2("1234 Test Street2");
		address.setCity("Test City");
		address.setState("TEST");
		address.setZipCode("1234");
	}

	@AfterEach
	void tearDown() throws Exception {
		address = null;
		em.close();
	}

	@Test
	@DisplayName("Test get address by id")
	void test_getAddressById() {
//		assertEquals(1, em.find(Address.class, 1).getId());
		Address addressById = addressDAO.getAddressById(1);
		System.out.println(addressById);
		assertEquals("Greenwood Village", addressById.getCity());
	}

}
