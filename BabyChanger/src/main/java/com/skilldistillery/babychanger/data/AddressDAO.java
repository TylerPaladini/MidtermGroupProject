package com.skilldistillery.babychanger.data;

import java.util.List;

import com.skilldistillery.babychanger.entities.Address;

public interface AddressDAO {

	public Address getAddressById(int id);
	
	public List<Address> getAllAddresses();
	
	public Address createAddress(Address address);
	
	public boolean deleteAddress(int id);

	public Address updateAddress(int id, Address address);
}
