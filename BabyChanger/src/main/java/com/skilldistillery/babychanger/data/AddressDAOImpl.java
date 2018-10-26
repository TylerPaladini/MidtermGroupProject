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
	public Address getAddressById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address createAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAddress() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address updateAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
