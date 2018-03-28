package com.mybookmark.mybookmarkapi.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.entity.Bookmark;

@RestController
@RequestMapping(value="/bookmarks")
public class BookmarksController {

	@RequestMapping(method=RequestMethod.GET, value="/{bookmarkId}")
	public Bookmark readBookmark() {
		return new Bookmark(1, "google", "google.com", "google site", null);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Bookmark> readBookmarks() {
		ArrayList<Bookmark> bookmarks = new ArrayList<>();
		bookmarks.add(new Bookmark(1, "google", "google.com", "google site", null));
		return bookmarks;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Bookmark createBookmark(@RequestBody Bookmark input) {
		return input;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{bookmarkId}")
	public Bookmark updateBookmark(@PathVariable String bookmarkId, @RequestBody Bookmark input) {
		return input;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookmarkId}")
	public void deleteBookmark(@PathVariable String bookmarkId) {
		System.out.println(bookmarkId);
	}
	
}
