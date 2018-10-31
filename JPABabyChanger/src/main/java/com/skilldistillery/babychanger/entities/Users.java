package com.skilldistillery.babychanger.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Required field")
	@Size(min = 5, max = 35)
	@Column(name = "username")
	private String userName;

	@NotEmpty(message = "Required field")
	@Email
	private String email;

	@NotEmpty(message = "Required field")
	@Pattern(regexp = "(?=^.{5,15}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?\\/&gt;.&lt;,])(?!.*\\s).*$",
			message = "Password must contain, one lower-case letter, one upper-case letter, one number, and one special character")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dateCreated;

	private boolean active;

	private boolean admin;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> comments;

	/*
	 * getters / setters
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		if (comments == null)
			comments = new ArrayList<>();

		if (!comments.contains(comment)) {
			comments.add(comment);
			if (comment.getUser() != null) {
				comment.getUser().getComments().remove(comment);
			}
			comment.setUser(this);
		}
	}

	public void removeComment(Comment comment) {
		comment.setUser(null);
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
		Users other = (Users) obj;
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
		builder.append("Users [id=");
		builder.append(id);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", active=");
		builder.append(active);
		builder.append(", admin=");
		builder.append(admin);
		builder.append("]");
		return builder.toString();
	}

	/*
	 * constructors
	 */
	
	public Users() {

	}
	
	public Users(int id, String userName, String email, String password, String firstName, String lastName,
			Date dateCreated, boolean active, boolean admin) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateCreated = dateCreated;
		this.active = active;
		this.admin = admin;
	}

}
