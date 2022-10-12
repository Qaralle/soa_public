package com.example.crud.controller;

import com.example.crud.dto.ResultDto;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.service.StudyGroupExpelledService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.crud.util.ResponseBuilder.buildResultDtoResponse;

@Validated
@RestController
@RequestMapping(value = "/groups/expelled",
        produces = "application/xml")
public class StudyGroupExpelledController extends AbstractController{
    private final StudyGroupExpelledService studyGroupCrudService;

    public StudyGroupExpelledController(StudyGroupExpelledService studyGroupCrudService) {
        this.studyGroupCrudService = studyGroupCrudService;
    }

    @GetMapping(value = "/should-be/avg")
    public ResponseEntity<ResultDto> calculateAvg() {
        ResultDto resultDto = studyGroupCrudService.calculateAvg();

        return buildResultDtoResponse(resultDto);
    }

    @GetMapping(value = "/should-be/min")
    public ResponseEntity<StudyGroupResponseDto> getMin() {
        return ResponseEntity.ok(studyGroupCrudService.getMin());
    }
}
