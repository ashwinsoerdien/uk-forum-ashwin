package com.ashwin.ukforum.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User implements Serializable {
	
	private static final long serialVersionUID = -7659216941583991925L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username", nullable=false, length=30, unique=true)
	@Size(min=6, message="Your username must contain at least 6 characters")
	private String username;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@Column(name="created_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Column(name="updated_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	@Column(name="is_admin", nullable=false)
	private boolean admin = false;	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Article> articles = new ArrayList<Article>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Comment> comments = new ArrayList<Comment>();

	public User() {
		this.admin = false;
		this.created_at = new Date();
		this.updated_at = this.created_at;
	}	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", is_admin=" + admin + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;		
		return true;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
