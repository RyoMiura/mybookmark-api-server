package com.mybookmark.mybookmarkapi.domain.bookmark;


public class TagDto {
	
	private long tagId;	
	private String name;

	
	public long getTagId() {
		return tagId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
