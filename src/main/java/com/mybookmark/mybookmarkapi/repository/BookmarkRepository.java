package com.mybookmark.mybookmarkapi.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmark.mybookmarkapi.entity.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	Collection<Bookmark> findByBookmarkId(int bookmarkId);
}
