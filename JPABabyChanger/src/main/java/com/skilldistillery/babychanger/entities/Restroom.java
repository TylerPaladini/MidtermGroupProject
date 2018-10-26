package com.skilldistillery.babychanger.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "restroom")
public class Restroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String picture;

	private Boolean flagged;

	@Column(name = "flagged_reason")
	private String flaggedReason;

	@Column(name = "flagged_date")
	private Date flaggedDate;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String directions;

	@Column(name = "public")
	private Boolean pAccess;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "date_created")
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreationTimestamp
	private Date dateCreated;

	private String description;

	@Column(name = "changing_table")
	private Boolean changingTable;

	public Boolean getChangingTable() {
		return changingTable;
	}

	public void setChangingTable(Boolean changingTable) {
		this.changingTable = changingTable;
	}

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToMany(mappedBy = "restroom")
	private List<Comment> comments;

	
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Boolean getFlagged() {
		return flagged;
	}

	public void setFlagged(Boolean flagged) {
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public Boolean getpAccess() {
		return pAccess;
	}

	public void setpAccess(Boolean pAccess) {
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	
	public Restroom () {
		
	}
	
	public Restroom(int id, String picture, Boolean flagged, String flaggedReason, Date flaggedDate, Gender gender,
			String directions, Boolean pAccess, int userId, Date dateCreated, String description, Boolean changingTable,
			Location location, List<Comment> comments) {
		super();
		this.id = id;
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
		this.comments = comments;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changingTable == null) ? 0 : changingTable.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((directions == null) ? 0 : directions.hashCode());
		result = prime * result + ((flagged == null) ? 0 : flagged.hashCode());
		result = prime * result + ((flaggedDate == null) ? 0 : flaggedDate.hashCode());
		result = prime * result + ((flaggedReason == null) ? 0 : flaggedReason.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((pAccess == null) ? 0 : pAccess.hashCode());
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
		if (changingTable == null) {
			if (other.changingTable != null)
				return false;
		} else if (!changingTable.equals(other.changingTable))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
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
		if (flagged == null) {
			if (other.flagged != null)
				return false;
		} else if (!flagged.equals(other.flagged))
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
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (pAccess == null) {
			if (other.pAccess != null)
				return false;
		} else if (!pAccess.equals(other.pAccess))
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

	@Override
	public String toString() {
		return "Restroom [id=" + id + ", picture=" + picture + ", flagged=" + flagged + ", flaggedReason="
				+ flaggedReason + ", flaggedDate=" + flaggedDate + ", gender=" + gender + ", directions=" + directions
				+ ", pAccess=" + pAccess + ", userId=" + userId + ", dateCreated=" + dateCreated + ", description="
				+ description + ", changingTable=" + changingTable + ", location=" + location + ", comments=" + comments
				+ "]";
	}

	public void addComment(Comment comment) {
		if(comments == null) comments = new ArrayList<>();
		
		if(!comments.contains(comment)) {
			comments.add(comment);
			if(comment.getRestroom() != null) {
				comment.getRestroom().getComments().remove(comment);
			}
			comment.setRestroom(this);
		}
	}
	public void removeComment(Comment comment) {
		comment.setRestroom(null);
		if(comments != null) {
			comments.remove(comment);
		}
	}
	
	

}
