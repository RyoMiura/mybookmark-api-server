package com.mybookmark.mybookmarkapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybookmark.mybookmarkapi.domain.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer> {
	AuthorityEntity findByRole(String role);
}
