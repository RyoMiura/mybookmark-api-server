package com.mybookmark.mybookmarkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmark.mybookmarkapi.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
