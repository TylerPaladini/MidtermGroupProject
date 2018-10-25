package com.skilldistillery.babychanger.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "restroom_id")
	private Restroom restroom;

	private String comment;

	@Column(name = "flag_comment")
	private boolean flagComment;

	@Enumerated(EnumType.ORDINAL)
	private Rating rating;

	private boolean active;

	@Column(name = "date_created")
	private Date dateCreated;

	public Comment() {
	}

	public Comment(int id, Users user, Restroom restroom, String comment, boolean flagComment, Rating rating,
			boolean active, Date dateCreated) {
		super();
		this.id = id;
		this.user = user;
		this.restroom = restroom;
		this.comment = comment;
		this.flagComment = flagComment;
		this.rating = rating;
		this.active = active;
		this.dateCreated = dateCreated;
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
		Comment other = (Comment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Restroom getRestroom() {
		return restroom;
	}

	public void setRestroom(Restroom restroom) {
		this.restroom = restroom;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isFlagComment() {
		return flagComment;
	}

	public void setFlagComment(boolean flagComment) {
		this.flagComment = flagComment;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", restroom=");
		builder.append(restroom);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", flagComment=");
		builder.append(flagComment);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", active=");
		builder.append(active);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append("]");
		return builder.toString();
	}

}
