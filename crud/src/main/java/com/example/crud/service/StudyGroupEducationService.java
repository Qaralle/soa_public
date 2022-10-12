package com.example.crud.service;

import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.model.StudyGroup;
import com.example.crud.repository.StudyGroupJpaRepository;
import com.example.crud.repository.StudyGroupRepository;
import com.example.crud.service.exception.EmptyCollectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StudyGroupEducationService {
    private final StudyGroupRepository repository;
    private final ConversionService conversionService;

    public StudyGroupEducationService(StudyGroupRepository repository,
                                      ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    public StudyGroupResponseDto getWithMaxFormOfEducation(){
        Sort formOfEducationSort = Sort.by(Sort.Order.desc("formOfEducation"));
        StudyGroup max = repository.findAll(PageRequest.of(0,1,formOfEducationSort))
                .stream()
                .findFirst()
                .orElseThrow(() -> {throw new EmptyCollectionException("collection is empty");});

        return conversionService.convert(max, StudyGroupResponseDto.class);
    }
}
