package com.example.crud.controller;

import com.example.crud.dto.StudyGroupFilter;
import com.example.crud.dto.StudyGroupList;
import com.example.crud.dto.StudyGroupRequestDto;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.service.StudyGroupCrudService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping(value = "/groups",
                produces = "application/xml")
public class StudyGroupCrudRestController extends AbstractController{
    private final StudyGroupCrudService studyGroupCrudService;
    private final ConversionService conversionService;

    public StudyGroupCrudRestController(StudyGroupCrudService studyGroupCrudService,
                                        ConversionService conversionService) {
        this.studyGroupCrudService = studyGroupCrudService;
        this.conversionService = conversionService;
    }

    @PostMapping(value = "")
    public ResponseEntity<StudyGroupResponseDto> create(@RequestBody StudyGroupRequestDto requestDto) {
        return ResponseEntity.ok(studyGroupCrudService.create(requestDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudyGroupResponseDto> getGroupById(@Min(1L) @PathVariable Long id) {
        return ResponseEntity.ok(studyGroupCrudService.getGroupById(id));
    }

    @PostMapping(value = "/filter")
    public ResponseEntity<StudyGroupList> getAll(@RequestBody StudyGroupFilter filter) {
        return ResponseEntity.ok(studyGroupCrudService.getAll(filter));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StudyGroupResponseDto> update(@Min(1L) @PathVariable Long id,
                                                        @RequestBody StudyGroupRequestDto requestDto) {
        return ResponseEntity.ok(studyGroupCrudService.update(id, requestDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@Min(1L) @PathVariable Long id) {
        studyGroupCrudService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
