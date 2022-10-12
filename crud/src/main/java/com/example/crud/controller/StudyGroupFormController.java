package com.example.crud.controller;

import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.service.StudyGroupEducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value = "/groups/education",
        produces = "application/xml")
public class StudyGroupFormController extends AbstractController {
    private final StudyGroupEducationService studyGroupEducationService;

    public StudyGroupFormController(StudyGroupEducationService studyGroupEducationService) {
        this.studyGroupEducationService = studyGroupEducationService;
    }

    @GetMapping(value = "/form/max")
    public ResponseEntity<StudyGroupResponseDto> calculateAvg() {
        return ResponseEntity.ok(studyGroupEducationService.getWithMaxFormOfEducation());
    }
}
