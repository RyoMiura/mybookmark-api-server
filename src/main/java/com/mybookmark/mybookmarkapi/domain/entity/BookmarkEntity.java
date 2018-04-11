package com.mybookmark.mybookmarkapi.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class BookmarkEntity extends EntityBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long bookmarkId;

	@Column(length = 100, nullable = false)
	private String title;

	@Column(length = 300, nullable = false)
	private String url;

	@Column(length = 300)
	private String overview;

	@ManyToMany
	private Set<TagEntity> tags;

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

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getOverview() {
		return overview;
	}

	public Set<TagEntity> getTags() {
		return tags;
	}

	public void setBookmarkId(long bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setTags(Set<TagEntity> tags) {
		this.tags = tags;
	}

}
