package com.example.crud.repository;

import com.example.crud.model.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudyGroupJpaRepository extends JpaRepository<StudyGroup, Long>,
        QuerydslPredicateExecutor<StudyGroup> {
}
