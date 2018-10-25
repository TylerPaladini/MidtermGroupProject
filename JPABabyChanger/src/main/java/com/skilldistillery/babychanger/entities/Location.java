package com.skilldistillery.babychanger.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	@Column(name = "access_limits")
	private String accessLimits;
	@Column(name = "purchase_required")
	private boolean purchaseRequired;
	private String phone;
	private Date openTime;
	private Date closeTime;
	@OneToMany(mappedBy="location")
	private List<Restroom> restrooms;
	
	
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

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	
	public void addRestroom(Restroom restroom) {
        if(this.restrooms == null) {
            this.restrooms = new ArrayList<>();
        }
        if(!restrooms.contains(restrooms)) {
        	restrooms.add(restroom);
            restroom.addLocation(this);
        }
    }
    
    public void removeRestroom(Restroom restroom) {
        if(this.restrooms != null && this.restrooms.contains(restroom)) {
            this.restrooms.remove(restroom);
            restroom.removeLocation(this);
        }
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
		Location other = (Location) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", address=" + address + ", accessLimits=" + accessLimits
				+ ", purchaseRequired=" + purchaseRequired + ", phone=" + phone + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + "]";
	}
	
	public Location() {
		super();
	}

	public Location(int id, String name, Address address, String accessLimits, boolean purchaseRequired, String phone,
			Date openTime, Date closeTime) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.accessLimits = accessLimits;
		this.purchaseRequired = purchaseRequired;
		this.phone = phone;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
}
