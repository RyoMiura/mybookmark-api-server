package com.mybookmark.mybookmarkapi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmark.mybookmarkapi.entity.BookmarkEntity;

public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
	Collection<BookmarkEntity> findByBookmarkId(int bookmarkId);
}
