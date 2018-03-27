package com.mybookmark.mybookmarkapi.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.model.Bookmark;

@RestController
public class BookmarksController {

	@RequestMapping(method=RequestMethod.GET, value="/bookmarks/{bookmarkId}")
	public Bookmark getBookmark() {
		return new Bookmark(1, "google", "google.com", "google site", null, 1);
	}
	
//	@RequestMapping(method=RequestMethod.GET, value="/bookmakrs")
//	public Collection<Bookmark> getBookmarks() {
//		
//	}
	
}
