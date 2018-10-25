package com.skilldistillery.babychanger.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="restroom")
public class Restroom {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 

	@Column(name="location_id")
	private int locationId; 
	
	private String picture; 
	
	private boolean flagged; 
	
	@Column(name="flagged_reason")
	private String flaggedReason; 
	
	@Column(name="flagged_date")
	private Date flaggedDate; 
	
	private Enum gender; 
	
	private String directions; 
	
	@Column(name="public")
	private boolean pAccess; 
	
	@Column(name="user_id")
	private int userId; 
	
	@Column(name="date_created")
	private Date dateCreated; 
	
	private String description; 
	
	@Column(name="changing_table")
	private boolean changingTable;
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location; 
	
	//getters and setters 
	
	

	public int getLocationId() {
		return locationId;
	}

	public Restroom(int id, int locationId, String picture, boolean flagged, String flaggedReason, Date flaggedDate,
			Enum gender, String directions, boolean pAccess, int userId, Date dateCreated, String description,
			boolean changingTable, Location location) {
		super();
		this.id = id;
		this.locationId = locationId;
		this.picture = picture;
		this.flagged = flagged;
		this.flaggedReason = flaggedReason;
		this.flaggedDate = flaggedDate;
		this.gender = gender;
		this.directions = directions;
		this.pAccess = pAccess;
		this.userId = userId;
		this.dateCreated = dateCreated;
		this.description = description;
		this.changingTable = changingTable;
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public String getFlaggedReason() {
		return flaggedReason;
	}

	public void setFlaggedReason(String flaggedReason) {
		this.flaggedReason = flaggedReason;
	}

	public Date getFlaggedDate() {
		return flaggedDate;
	}

	public void setFlaggedDate(Date flaggedDate) {
		this.flaggedDate = flaggedDate;
	}

	public Enum getGender() {
		return gender;
	}

	public void setGender(Enum gender) {
		this.gender = gender;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public boolean ispAccess() {
		return pAccess;
	}

	public void setpAccess(boolean pAccess) {
		this.pAccess = pAccess;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isChangingTable() {
		return changingTable;
	}

	public void setChangingTable(boolean changingTable) {
		this.changingTable = changingTable;
	}

	public int getId() {
		return id;
	}

	//to String 
	
	@Override
	public String toString() {
		return "Restroom [id=" + id + ", locationId=" + locationId + ", picture=" + picture + ", flagged=" + flagged
				+ ", flaggedReason=" + flaggedReason + ", flaggedDate=" + flaggedDate + ", gender=" + gender
				+ ", directions=" + directions + ", pAccess=" + pAccess + ", userId=" + userId + ", dateCreated="
				+ dateCreated + ", description=" + description + ", changingTable=" + changingTable + ", location="
				+ location + "]";
	}
	
	//constructors

	public Restroom(int id, int locationId, String picture, boolean flagged, String flaggedReason, Date flaggedDate,
			Enum gender, String directions, boolean pAccess, int userId, Date dateCreated, String description,
			boolean changingTable) {
		super();
		this.id = id;
		this.locationId = locationId;
		this.picture = picture;
		this.flagged = flagged;
		this.flaggedReason = flaggedReason;
		this.flaggedDate = flaggedDate;
		this.gender = gender;
		this.directions = directions;
		this.pAccess = pAccess;
		this.userId = userId;
		this.dateCreated = dateCreated;
		this.description = description;
		this.changingTable = changingTable;
	} 
	
	public Restroom() {
		
	}

	//hash and equals 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (changingTable ? 1231 : 1237);
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((directions == null) ? 0 : directions.hashCode());
		result = prime * result + (flagged ? 1231 : 1237);
		result = prime * result + ((flaggedDate == null) ? 0 : flaggedDate.hashCode());
		result = prime * result + ((flaggedReason == null) ? 0 : flaggedReason.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + locationId;
		result = prime * result + (pAccess ? 1231 : 1237);
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + userId;
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
		Restroom other = (Restroom) obj;
		if (changingTable != other.changingTable)
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (directions == null) {
			if (other.directions != null)
				return false;
		} else if (!directions.equals(other.directions))
			return false;
		if (flagged != other.flagged)
			return false;
		if (flaggedDate == null) {
			if (other.flaggedDate != null)
				return false;
		} else if (!flaggedDate.equals(other.flaggedDate))
			return false;
		if (flaggedReason == null) {
			if (other.flaggedReason != null)
				return false;
		} else if (!flaggedReason.equals(other.flaggedReason))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (locationId != other.locationId)
			return false;
		if (pAccess != other.pAccess)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
}
