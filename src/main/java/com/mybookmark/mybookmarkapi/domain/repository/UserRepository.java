package com.mybookmark.mybookmarkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmark.mybookmarkapi.domain.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByLoginId(String loginId);
}
