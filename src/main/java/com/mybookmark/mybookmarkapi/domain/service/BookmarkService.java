package com.mybookmark.mybookmarkapi.domain.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mybookmark.mybookmarkapi.common.dto.BookmarkDto;
import com.mybookmark.mybookmarkapi.common.error.exception.NotFoundDBResourceException;
import com.mybookmark.mybookmarkapi.domain.entity.BookmarkEntity;
import com.mybookmark.mybookmarkapi.domain.repository.BookmarkRepository;
import com.mybookmark.mybookmarkapi.domain.util.converter.DtoEntityMapper;

import javassist.NotFoundException;

// TODO: DBExceptionに関するコードを追加する。
@Service
public class BookmarkService {

	@Autowired
	private BookmarkRepository bookmarkRepository;
	@Autowired
	private DtoEntityMapper dtoEntityMapper;
	
	public BookmarkDto readBookmark(long bookmarkId) {
		BookmarkEntity entity = bookmarkRepository.findByBookmarkId(bookmarkId);
		if (entity != null) {
			return dtoEntityMapper.fromEntityToDto(entity, BookmarkDto.class);
		} else {
			throw new NotFoundDBResourceException();
		}
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
	
	public void updateBookmark(long bookmarkId, BookmarkDto dto) {
		BookmarkEntity hasEntity = bookmarkRepository.findByBookmarkId(bookmarkId);
		if (hasEntity != null) {
			BookmarkEntity entity = dtoEntityMapper.fromDtoToEntity(dto, BookmarkEntity.class);
			entity.setBookmarkId(bookmarkId);
			bookmarkRepository.save(entity);
		} else {
			throw new NotFoundDBResourceException();
		}
	}
	
	
	public void deleteBookmark(long bookmarkId) {
		try {
			bookmarkRepository.deleteById(bookmarkId);			
		} catch(EmptyResultDataAccessException e) {
			throw new NotFoundDBResourceException();
		}
	}
}
