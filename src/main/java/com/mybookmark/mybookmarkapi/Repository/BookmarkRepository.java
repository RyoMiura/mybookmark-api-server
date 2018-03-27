package com.mybookmark.mybookmarkapi.Repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmark.mybookmarkapi.model.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	Collection<Bookmark> findByBookmarkId(int bookmarkId);
}
