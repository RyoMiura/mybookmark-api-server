package com.mybookmark.mybookmarkapi.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	
	
	public BookmarkDto readBookmark(long bookmarkId) {
		BookmarkEntity entity = bookmarkRepository.findByBookmarkId(bookmarkId);
		return dtoEntityMapper.fromEntityToDto(entity, BookmarkDto.class);
	}
	
	public Collection<BookmarkDto> readBookmarks() {
		List<BookmarkEntity> entities = bookmarkRepository.findAll();
		List<BookmarkDto> dtos = new ArrayList<>();
		entities.forEach(entity -> {
			dtos.add(dtoEntityMapper.fromEntityToDto(entity, BookmarkDto.class));
		});
		return dtos;
	}
	
	public void createBookmark(BookmarkDto dto) {
		BookmarkEntity entity = dtoEntityMapper.fromDtoToEntity(dto, BookmarkEntity.class);
		bookmarkRepository.save(entity);
	}
}
