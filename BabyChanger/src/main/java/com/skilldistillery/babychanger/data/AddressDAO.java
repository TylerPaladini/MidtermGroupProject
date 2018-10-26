package com.skilldistillery.babychanger.data;

import java.util.List;

import com.skilldistillery.babychanger.entities.Address;

public interface AddressDAO {

	public Address getAddressById();
	
	public List<Address> getAllAddresses();
	
	public Address createAddress();
	
	public boolean deleteAddress();
	
	public Address updateAddress();
	
}
