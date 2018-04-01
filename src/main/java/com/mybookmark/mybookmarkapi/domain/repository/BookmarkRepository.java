package com.mybookmark.mybookmarkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmark.mybookmarkapi.domain.entity.BookmarkEntity;

public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
	BookmarkEntity findByBookmarkId(long bookmarkId);
}
