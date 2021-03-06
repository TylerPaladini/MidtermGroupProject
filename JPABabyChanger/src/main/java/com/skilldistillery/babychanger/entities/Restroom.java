package com.skilldistillery.babychanger.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "restroom")
public class Restroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String picture;

	@Column(name = "flagged_reason")
	private String flaggedReason;

	@Column(name = "flagged_date")
	private Date flaggedDate;

//	@NotEmpty(message = "Required field")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String directions;

	@Column(name = "public")
	private Boolean pAccess;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dateCreated;

	private String description;

//	@NotEmpty(message = "Required field")
	@Column(name = "changing_table")
	private Boolean changingTable;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "restroom", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@Column(name = "flagged")
	private Boolean flagRestroom;

	/*
	 * getters / setters
	 */

	public int getId() {
		return id;
	}

	public Boolean getChangingTable() {
		return changingTable;
	}

	public void setChangingTable(Boolean changingTable) {
		this.changingTable = changingTable;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public void setFlagRestroom(Boolean flagRestroom) {
		this.flagRestroom = flagRestroom;
	}

	public Boolean getFlagRestroom() {
		return flagRestroom;
	}

	public void addComment(Comment comment) {
		if (comments == null)
			comments = new ArrayList<>();

		if (!comments.contains(comment)) {
			comments.add(comment);
			if (comment.getRestroom() != null) {
				comment.getRestroom().getComments().remove(comment);
			}
			comment.setRestroom(this);
		}
	}

	public void removeComment(Comment comment) {
		comment.setRestroom(null);
		if (comments != null) {
			comments.remove(comment);
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
		Restroom other = (Restroom) obj;
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
		builder.append("Restroom [id=").append(id).append(", picture=").append(picture).append(", flagged=")
				.append(flagRestroom).append(", flaggedReason=").append(flaggedReason).append(", flaggedDate=")
				.append(flaggedDate).append(", gender=").append(gender).append(", directions=").append(directions)
				.append(", pAccess=").append(pAccess).append(", userId=").append(userId).append(", dateCreated=")
				.append(dateCreated).append(", description=").append(description).append(", changingTable=")
				.append(changingTable).append(", location=").append(location).append(", comments=")
				.append(comments.size()).append("]");
		return builder.toString();
	}

	/*
	 * constructors
	 */

	public Restroom() {

	}

	public Restroom(int id, String picture, Boolean flagged, String flaggedReason, Date flaggedDate, Gender gender,
			String directions, Boolean pAccess, int userId, Date dateCreated, String description, Boolean changingTable,
			Location location, List<Comment> comments) {
		super();
		this.id = id;
		this.picture = picture;
		this.flagRestroom = flagged;
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

}
