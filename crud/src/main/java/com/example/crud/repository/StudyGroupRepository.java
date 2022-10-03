package com.example.crud.repository;

import com.example.crud.model.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
}
