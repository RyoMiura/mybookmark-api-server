package com.mybookmark.mybookmarkapi.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.common.dto.BookmarkDto;
import com.mybookmark.mybookmarkapi.common.error.exception.NotFoundDBResourceException;
import com.mybookmark.mybookmarkapi.domain.service.BookmarkService;
import com.mybookmark.mybookmarkapi.web.form.CreateBookmarkForm;
import com.mybookmark.mybookmarkapi.web.util.converter.DtoFormMapper;

@RestController
@RequestMapping(value = "/bookmarks")
public class BookmarksController {

	@Autowired
	private DtoFormMapper dtoFormMapper;

	@Autowired
	private BookmarkService bookmarkService;

	@RequestMapping(method = RequestMethod.GET, value = "/{bookmarkId}")
	public BookmarkDto readBookmark(@PathVariable long bookmarkId) {
		return bookmarkService.readBookmark(bookmarkId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<BookmarkDto> readBookmarks() {
		return bookmarkService.readBookmarks();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createBookmark(@RequestBody @Valid CreateBookmarkForm input) {
		BookmarkDto dto = dtoFormMapper.fromFormToDto(input, BookmarkDto.class);
		bookmarkService.createBookmark(dto);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{bookmarkId}")
	public void updateBookmark(@PathVariable long bookmarkId, @RequestBody @Valid CreateBookmarkForm input) {
		BookmarkDto dto = dtoFormMapper.fromFormToDto(input, BookmarkDto.class);
		boolean isSuccess = bookmarkService.updateBookmark(bookmarkId, dto);
		if (!isSuccess) {
			throw new NotFoundDBResourceException();
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookmarkId}")
	public void deleteBookmark(@PathVariable long bookmarkId) {
		bookmarkService.deleteBookmark(bookmarkId);
	}

}
