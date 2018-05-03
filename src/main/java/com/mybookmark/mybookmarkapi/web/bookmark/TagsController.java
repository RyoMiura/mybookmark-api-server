package com.mybookmark.mybookmarkapi.web.bookmark;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.common.dto.TagDto;
import com.mybookmark.mybookmarkapi.common.error.exception.NotFoundDBResourceException;
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
	public void updateTag(@PathVariable long tagId, @RequestBody CreateTagForm input) {
		TagDto dto = dtoFormMapper.fromFormToDto(input, TagDto.class);
		boolean isSuccess = tagService.updateTag(tagId, dto);
		if (!isSuccess) {
			throw new NotFoundDBResourceException();
		}

	}

}
