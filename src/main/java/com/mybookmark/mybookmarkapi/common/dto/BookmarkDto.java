package com.mybookmark.mybookmarkapi.common.dto;

import java.util.Set;

public class BookmarkDto extends DtoBean {

	private long bookmarkId;
	private String title;
	private String url;
	private String overview;	
	private Set<TagDto> tags;
	
		
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

	public Set<TagDto> getTags() {
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

	public void setTags(Set<TagDto> tags) {
		this.tags = tags;
	}
	
}
