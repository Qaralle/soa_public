package com.example.crud.controller;

import com.example.crud.dto.StudyGroupFilter;
import com.example.crud.dto.StudyGroupList;
import com.example.crud.dto.StudyGroupRequestDto;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.model.StudyGroup;
import com.example.crud.service.StudyGroupCrudService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/university/groups",
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

    @GetMapping(value = "")
    public ResponseEntity<StudyGroupList> getAll(StudyGroupFilter filter) {
        StudyGroupList list = new StudyGroupList();
        list.setGroups(studyGroupCrudService.getAll(filter).getContent());
        list.setTotalSize(1);
        return ResponseEntity.ok(list);
    }
}
