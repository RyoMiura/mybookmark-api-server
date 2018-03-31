package com.mybookmark.mybookmarkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmark.mybookmarkapi.domain.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
