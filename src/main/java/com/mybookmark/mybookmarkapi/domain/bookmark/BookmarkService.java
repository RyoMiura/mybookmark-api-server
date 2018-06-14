package com.mybookmark.mybookmarkapi.domain.bookmark;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybookmark.mybookmarkapi.domain.user.UserEntity;
import com.mybookmark.mybookmarkapi.domain.user.UserRepository;
import com.mybookmark.mybookmarkapi.domain.util.converter.DtoEntityMapper;

@Service
public class BookmarkService {

	@Autowired
	private BookmarkRepository bookmarkRepository;
	@Autowired
	private UserRepository userReository;
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

	public void createBookmark(BookmarkDto dto, Principal principal) {
		UserEntity user = userReository.findByLoginId(principal.getName());
		BookmarkEntity entity = dtoEntityMapper.fromDtoToEntity(dto, BookmarkEntity.class);
		entity.setUser(user);
		bookmarkRepository.save(entity);
	}

	public boolean updateBookmark(long bookmarkId, BookmarkDto dto, Principal principal) {
		BookmarkEntity hasEntity = bookmarkRepository.findByBookmarkId(bookmarkId);
		UserEntity registered = userReository.findByLoginId(principal.getName());
		
		if (hasEntity != null && registered.getLoginId().equals(hasEntity.getUser().getLoginId())) {
			BookmarkEntity entity = dtoEntityMapper.fromDtoToEntity(dto, BookmarkEntity.class);
			entity.setBookmarkId(bookmarkId);
			entity.setUser(registered);
			bookmarkRepository.save(entity);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteBookmark(long bookmarkId, Principal principal) {
		BookmarkEntity bookmark = bookmarkRepository.findByBookmarkId(bookmarkId);
		UserEntity registered = userReository.findByLoginId(principal.getName());
		if (bookmark != null && registered.getLoginId().equals(bookmark.getUser().getLoginId())) {
			bookmarkRepository.deleteById(bookmarkId);
			return true;			
		} else {
			return false;
		}
	}
}
