package com.skilldistillery.babychanger.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Pattern(regexp = ".{3,}", message = "A street must be more than 2 characters")
	@NotEmpty(message = "Required field")
	private String street;

	private String street2;

	@Pattern(regexp = ".{3,}", message = "A city must be more than 2 characters")
	@NotEmpty(message = "Required field")
	private String city;

	@Pattern(regexp = "^([Aa][LKSZRAEPlkszraep]|[Cc][AOTaot]|[Dd][ECec]|[Ff][LMlm]|[Gg][AUau]|[Hh][Ii]|[Ii][ADLNadln]|[Kk][SYsy]|[Ll][Aa]|[Mm][ADEHINOPSTadehinopst]|[Nn][CDEHJMVYcdehjmvy]|[Oo][HKRhkr]|[Pp][ARWarw]|[Rr][Ii]|[Ss][CDcd]|[Tt][NXnx]|[Uu][Tt]|[Vv][AITait]|[Ww][AIVYaivy])$",
			message = "Please enter a US state abbreviation")
	@NotEmpty(message = "Required field")
	private String state;

	@Pattern(regexp = "\\d{5}(-\\d{4})?", message = "Please enter a US zip code")
	@Column(name = "zip")
	private String zipCode;

	/*
	 * getters and setters
	 */

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	/*
	 * hashcodes and equals
	 */

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * toString
	 */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=").append(id).append(", street=").append(street).append(", street2=")
				.append(street2).append(", city=").append(city).append(", state=").append(state).append(", zipCode=")
				.append(zipCode).append("]");
		return builder.toString();
	}

	/*
	 * constructors
	 */

	public Address() {

	}

	public Address(int id, String street, String street2, String city, String state, String zipCode) {
		super();
		this.id = id;
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
}
