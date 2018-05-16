package com.mybookmark.mybookmarkapi.web.bookmark;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.common.dto.BookmarkDto;
import com.mybookmark.mybookmarkapi.common.error.handler.ErrorResponse;
import com.mybookmark.mybookmarkapi.domain.bookmark.BookmarkService;
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
	public ResponseEntity<ErrorResponse> updateBookmark(HttpServletRequest request, @PathVariable long bookmarkId, @RequestBody @Valid CreateBookmarkForm input) {
		BookmarkDto dto = dtoFormMapper.fromFormToDto(input, BookmarkDto.class);
		boolean isSuccess = bookmarkService.updateBookmark(bookmarkId, dto);
		if (isSuccess) {
			return new ResponseEntity<ErrorResponse>(HttpStatus.OK);
		} else {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(status, request), status);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookmarkId}")
	public void deleteBookmark(@PathVariable long bookmarkId) {
		bookmarkService.deleteBookmark(bookmarkId);
	}

	
	/**
	 * リソース生成時、tagリソースに対する外部キー制約が発生した時のエラーハンドラ。
	 * 
	 * @param e			発生した例外
	 * @param request	リクエストオブジェクト
	 * @return			エラーレスポンス
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ DataIntegrityViolationException.class })
	@ResponseBody
	public ErrorResponse handleDuplicateDBValueError(DataIntegrityViolationException e, HttpServletRequest request) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST, request);
	}

	/**
	 * リソース更新時、tagリソースに対する外部キー制約が発生した時のエラーハンドラ。
	 * 
	 * @param e			発生した例外
	 * @param request	リクエストオブジェクト
	 * @return			エラーレスポンス
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ EntityNotFoundException.class })
	@ResponseBody
	public ErrorResponse handleEntityNotFoundError(EntityNotFoundException e, HttpServletRequest request) {
		System.out.println(e.getStackTrace());
		return new ErrorResponse(HttpStatus.BAD_REQUEST, request);
	}
}
