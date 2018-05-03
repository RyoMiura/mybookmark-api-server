package com.mybookmark.mybookmarkapi.domain.bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
	TagEntity findByTagId(long tagId);
}
