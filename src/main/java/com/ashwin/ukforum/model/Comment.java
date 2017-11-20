package com.ashwin.ukforum.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author ashwin
 * Comment model to hold comments for an Article
 */
@Entity
@Table(name="comments")
public class Comment implements Serializable {

	private static final long serialVersionUID = -7891339676364041183L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="article_id", nullable=false)
	private Article article;
	
    @Lob
    @Column(nullable = false)
    @NotBlank
	private String content;
    
    @Column(name="created_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Column(name="updated_at", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	
	/**
	 * 
	 * @param article
	 * @param user
	 * @param content
	 */
	public Comment(Article article, User user, String content) {
		this.article = article;
		this.user = user;
		this.content = content;
		this.created_at = this.updated_at = new Date();
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
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated_at() {
		return created_at;
	}
	
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}
	
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}