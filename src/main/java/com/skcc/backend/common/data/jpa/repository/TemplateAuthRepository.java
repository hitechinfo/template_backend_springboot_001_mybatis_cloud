package com.skcc.backend.common.data.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcc.backend.common.data.jpa.entity.TemplateAuth;

public interface TemplateAuthRepository extends JpaRepository<TemplateAuth, String> {
	Optional<TemplateAuth> findByAuthUserId(String authUserId);
}