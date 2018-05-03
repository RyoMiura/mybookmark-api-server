package com.mybookmark.mybookmarkapi.domain.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
	BookmarkEntity findByBookmarkId(long bookmarkId);
}
