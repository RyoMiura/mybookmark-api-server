package com.mybookmark.mybookmarkapi.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.entity.TagEntity;

@RestController
@RequestMapping(value = "/tags")
public class TagsController {

	@RequestMapping(method = RequestMethod.GET)
	public Collection<TagEntity> readTags() {
		ArrayList<TagEntity> tags = new ArrayList<>();
		tags.add(new TagEntity(0, "java"));
		tags.add(new TagEntity(1, "javascript"));
		tags.add(new TagEntity(2, "google chrome"));
		return tags;
	}

	@RequestMapping(method = RequestMethod.POST)
	public TagEntity createTag(@RequestBody TagEntity input) {
		System.out.println(input.getName());
		return input;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{tagId}")
	public void deleteTag(@PathVariable String tagId) {
		System.out.println(tagId);
	}

}
