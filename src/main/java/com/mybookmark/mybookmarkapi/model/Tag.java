package com.mybookmark.mybookmarkapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagId;
	
	private String name;
	
	@ManyToMany(mappedBy = "tags")
	private List<Bookmark> bookmarks;
	
	private Tag() {
		
	}
	
	public Tag(long tagId, String name) {
		this.tagId = tagId;
		this.name = name;
	}

	public long getTagId() {
		return tagId;
	}

	public String getName() {
		return name;
	}

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}	
	

//	public void setTagId(long tagId) {
//		this.tagId = tagId;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
	
}
