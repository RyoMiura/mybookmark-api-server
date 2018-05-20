package com.mybookmark.mybookmarkapi.web.bookmark;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

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

import com.mybookmark.mybookmarkapi.common.error.handler.ErrorResponse;
import com.mybookmark.mybookmarkapi.domain.bookmark.TagDto;
import com.mybookmark.mybookmarkapi.domain.bookmark.TagService;
import com.mybookmark.mybookmarkapi.web.util.converter.DtoFormMapper;

@RestController
@RequestMapping(value = "/tags")
public class TagsController {
	
	@Autowired
	private DtoFormMapper dtoFormMapper;
	
	@Autowired
	private TagService tagService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<TagDto> readTags() {
		return tagService.readTags();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createTag(@RequestBody CreateTagForm input) {
		TagDto dto = dtoFormMapper.fromFormToDto(input, TagDto.class);
		tagService.createTag(dto);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{tagId}")
	public ResponseEntity<ErrorResponse> updateTag(HttpServletRequest request, @PathVariable long tagId, @RequestBody CreateTagForm input) {
		TagDto dto = dtoFormMapper.fromFormToDto(input, TagDto.class);
		boolean isSuccess = tagService.updateTag(tagId, dto);
		if (isSuccess) {
			return new ResponseEntity<ErrorResponse>(HttpStatus.OK);
		} else {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(status, request), status);
		}
	}
	
	
	/**
	 * 同名のタグ名を登録しようとしたときに発生するユニークキー制約のエラーハンドラ
	 * 
	 * @param e			発生した例外
	 * @param request	リクエストオブジェクト
	 * @return			エラーレスポンス
	 */
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody
	public ErrorResponse handleDuplicateKeyStoredError(DataIntegrityViolationException e, HttpServletRequest request) {
		return new ErrorResponse(HttpStatus.CONFLICT, request);
	}

}
