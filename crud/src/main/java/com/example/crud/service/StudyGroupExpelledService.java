package com.example.crud.service;

import com.example.crud.dto.ResultDto;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.model.StudyGroup;
import com.example.crud.repository.StudyGroupRepository;
import com.example.crud.service.exception.EmptyCollectionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.crud.util.CollectionUtils.assertEmpty;

@Service
public class StudyGroupExpelledService {
    private final StudyGroupRepository repository;
    private final ConversionService conversionService;

    public StudyGroupExpelledService(StudyGroupRepository repository,
                                     ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    public ResultDto calculateAvg() {
        List<StudyGroup> studyGroups = repository.findAll();

        assertEmpty(studyGroups);

        Double avg = (studyGroups.stream()
                .map(StudyGroup::getShouldBeExpelled)
                .reduce(0L, Long::sum)) / (double) studyGroups.size();


        return conversionService.convert(avg, ResultDto.class);
    }

    public StudyGroupResponseDto getMin() {
        Sort expelledSort = Sort.by(Sort.Order.asc("shouldBeExpelled"));
        StudyGroup max = repository.findAll(PageRequest.of(0,1,expelledSort))
                .stream()
                .findFirst()
                .orElseThrow(() -> {throw new EmptyCollectionException("collection is empty");});

        return conversionService.convert(max, StudyGroupResponseDto.class);
    }
}
