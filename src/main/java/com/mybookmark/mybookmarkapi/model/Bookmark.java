package com.mybookmark.mybookmarkapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookmarkId;
	
	private String title;

	private String url;
	
	private String overview;
	
	@OneToMany
	private Set<Tag> tags = new HashSet<>();
	
	private int referedCount;
	
	private Bookmark() {
		
	};
	
	public Bookmark(long bookmarkId, String tilte, String url, String overview, Set<Tag> tags, int referedCount) {
		this.bookmarkId = bookmarkId;
		this.title = tilte;
		this.url = url;
		this.overview = overview;
		this.tags = tags;
		this.referedCount = referedCount;
	}

	public long getBookmarkId() {
		return bookmarkId;
	}

	public String getTilte() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getOverview() {
		return overview;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public int getReferedCount() {
		return referedCount;
	}

//	public void setBookmarkId(long bookmarkId) {
//		this.bookmarkId = bookmarkId;
//	}
//
//	public void setTilte(String tilte) {
//		this.tilte = tilte;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	public void setOverview(String overview) {
//		this.overview = overview;
//	}
//
//	public void setTags(Set<Tag> tags) {
//		this.tags = tags;
//	}
//
//	public void setReferedCount(int referedCount) {
//		this.referedCount = referedCount;
//	}

}
