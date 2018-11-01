package com.skilldistillery.babychanger.entities;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Required field")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "access_limits")
	private String accessLimits;

	@Column(name = "purchase_required")
	private boolean purchaseRequired;

	@Pattern(regexp = "(?:[0-9]{3}-[0-9]{3}-[0-9]{4})?", message = "Please enter a US phone number with leading area code")
	private String phone;

//	@NotNull
//	@Pattern(regexp="([01]?[0-9]|2[0-3]):[0-5][0-9]", message = "Enter 24 hour format")
//	@Temporal(TemporalType.TIME)
	@Column(name = "open_time")
	private Time openTime;
	
//	@NotNull
//	@Pattern(regexp="([01]?[0-9]|2[0-3]):[0-5][0-9]", message = "Enter 24 hour format")
//	@Temporal(TemporalType.TIME)
	@Column(name = "closed_time")
	private Time closeTime;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "location", cascade = CascadeType.ALL)
	private Set<Restroom> restrooms;

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dateCreated;

	/*
	 * getters / setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAccessLimits() {
		return accessLimits;
	}

	public void setAccessLimits(String accessLimits) {
		this.accessLimits = accessLimits;
	}

	public boolean isPurchaseRequired() {
		return purchaseRequired;
	}

	public void setPurchaseRequired(boolean purchaseRequired) {
		this.purchaseRequired = purchaseRequired;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Time getOpenTime() {
		return openTime;
	}

//	public void setOpenTime(String openTime) {
//		this.openTime = Time.valueOf( openTime + ":00");
//		
//	}

	public Time getCloseTime() {
		return closeTime;
	}

//	public void setCloseTime(String closeTime) {
//		
//		this.closeTime = Time.valueOf(closeTime + ":00");
//	}

//	public void setOpenTime(String openTime) {
//		this.openTime = null;
//	}

	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}

//	public void setCloseTime(String closeTime) {
//		this.closeTime = null;
//	}

	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<Restroom> getRestrooms() {
		return restrooms;
	}

	public void setRestrooms(Set<Restroom> restrooms) {
		this.restrooms = restrooms;
	}

	public void addRestroom(Restroom restroom) {
		if (restrooms == null)
			restrooms = new HashSet<>();

		if (!restrooms.contains(restroom)) {
			restrooms.add(restroom);
			if (restroom.getLocation() != null) {
				restroom.getLocation().getRestrooms().remove(restroom);
			}
			restroom.setLocation(this);
		}
	}

	public void removeRestroom(Restroom restroom) {
		restroom.setLocation(null);
		if (restrooms != null) {
			restrooms.remove(restroom);
		}
	}

	/*
	 * hashCode and equals
	 */

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
		Location other = (Location) obj;
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
		builder.append("Location [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", accessLimits=");
		builder.append(accessLimits);
		builder.append(", purchaseRequired=");
		builder.append(purchaseRequired);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", openTime=");
		builder.append(openTime == null ? "NA" : openTime);
		builder.append(", closeTime=");
		builder.append(closeTime == null ? "NA" : closeTime);
		builder.append(", restrooms=");
		builder.append(restrooms == null ? "NA" : restrooms.size());
		builder.append(", dateCreated=");
		builder.append(dateCreated == null ? "NA" : dateCreated);
		builder.append("]");
		return builder.toString();
	}

	/*
	 * constructors
	 */

	public Location() {
		super();
	}

	public Location(int id, String name, Address address, String accessLimits, boolean purchaseRequired, String phone,
			Time openTime, Time closeTime, Set<Restroom> restrooms, Date dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.accessLimits = accessLimits;
		this.purchaseRequired = purchaseRequired;
		this.phone = phone;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.restrooms = restrooms;
		this.dateCreated = dateCreated;
	}

}
