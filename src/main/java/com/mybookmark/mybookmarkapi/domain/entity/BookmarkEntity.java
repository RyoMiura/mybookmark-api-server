package com.mybookmark.mybookmarkapi.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Columns;

@Entity(name="bookmark")
public class BookmarkEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookmarkId;
	
	@Column(length = 100)
	private String title;

	@Column(length = 300)
	private String url;
	
	@Column(length = 300)
	private String overview;
	
	@OneToMany
	private Set<TagEntity> tags;
	
//	@Column(columnDefinition="BIGINT default 0")
//	private long referedCount;
	
	private BookmarkEntity() {
		
	};
	
	public BookmarkEntity(long bookmarkId, String tilte, String url, String overview, Set<TagEntity> tags) {
		this.bookmarkId = bookmarkId;
		this.title = tilte;
		this.url = url;
		this.overview = overview;
		this.tags = tags;
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

//	public long getReferedCount() {
//		return referedCount;
//	}

	public Set<TagEntity> getTags() {
		return tags;
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
