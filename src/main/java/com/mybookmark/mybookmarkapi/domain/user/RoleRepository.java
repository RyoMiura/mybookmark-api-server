package com.mybookmark.mybookmarkapi.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	RoleEntity findByRole(String role);
}
