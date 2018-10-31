package com.skilldistillery.babychanger.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.babychanger.entities.Address;

@Transactional
@Repository
public class AddressDAOImpl implements AddressDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Address getAddressById(int id) {
		Address address = em.find(Address.class, id);
		return address;
	}

	@Override
	public List<Address> getAllAddresses() {
		String query = "SELECT address FROM Address address";
		List<Address> addressList = em.createQuery(query, Address.class).getResultList();
		return addressList;
	}

	@Override
	public Address createAddress(Address address) {
		em.persist(address);
		em.flush();
		if(address.getId() == 0) {
			em.getTransaction().rollback();
		}
		return address;
	}

	@Override
	public boolean deleteAddress(int id) {
		boolean destroyed;
		Address toDestroy = em.find(Address.class, id);
		em.remove(toDestroy);
		if(em.contains(toDestroy)) {
			destroyed = false;
			em.getTransaction().rollback();
		}
		else {
			destroyed = true;
		}
		return destroyed;
	}

	@Override
	public Address updateAddress(int id, Address address) {
		Address updateAddress = em.find(Address.class, id);
		if(updateAddress != null) {
			updateAddress.setStreet(address.getStreet());
			updateAddress.setStreet2(address.getStreet2());
			updateAddress.setCity(address.getCity());
			updateAddress.setState(address.getState().toUpperCase());
			updateAddress.setZipCode(address.getZipCode());
		}	
		return updateAddress;
	}
}
