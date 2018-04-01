package com.mybookmark.mybookmarkapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybookmark.mybookmarkapi.common.dto.BookmarkDto;
import com.mybookmark.mybookmarkapi.domain.entity.BookmarkEntity;
import com.mybookmark.mybookmarkapi.domain.repository.BookmarkRepository;
import com.mybookmark.mybookmarkapi.domain.util.converter.DtoEntityMapper;

@Service
public class BookmarkService {

	@Autowired
	private BookmarkRepository bookmarkRepository;
	@Autowired
	private DtoEntityMapper dtoEntityMapper;
	
	public void createBookmark(BookmarkDto dto) {
		BookmarkEntity entity = dtoEntityMapper.fromDtoToEntity(dto, BookmarkEntity.class);
		bookmarkRepository.save(entity);
	}
}
