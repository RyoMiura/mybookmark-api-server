package com.mybookmark.mybookmarkapi.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames="name"))
public class TagEntity extends EntityBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long tagId;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private List<BookmarkEntity> bookmarks;
	
	
	public long getTagId() {
		return tagId;
	}

	public String getName() {
		return name;
	}

	public List<BookmarkEntity> getBookmarks() {
		return bookmarks;
	}	
	
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBookmarks(List<BookmarkEntity> bookmarks) {
		this.bookmarks = bookmarks;
	}
	
	
	
}
