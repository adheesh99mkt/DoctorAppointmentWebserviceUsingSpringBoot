package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.FeedBackEntity;

public interface FeedbackRepository extends JpaRepository<FeedBackEntity, Long> {

}
