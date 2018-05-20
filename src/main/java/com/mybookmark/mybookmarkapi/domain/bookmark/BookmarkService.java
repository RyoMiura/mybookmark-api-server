package com.mybookmark.mybookmarkapi.domain.bookmark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mybookmark.mybookmarkapi.common.error.handler.ErrorResponse;
import com.mybookmark.mybookmarkapi.domain.util.converter.DtoEntityMapper;

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
			return null;
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

	public boolean updateBookmark(long bookmarkId, BookmarkDto dto) {
		BookmarkEntity hasEntity = bookmarkRepository.findByBookmarkId(bookmarkId);
		if (hasEntity != null) {
			BookmarkEntity entity = dtoEntityMapper.fromDtoToEntity(dto, BookmarkEntity.class);
			entity.setBookmarkId(bookmarkId);
			bookmarkRepository.save(entity);
			return true;
		} else {
			return false;
		}
	}

	public void deleteBookmark(long bookmarkId) {
		bookmarkRepository.deleteById(bookmarkId);
	}

}
