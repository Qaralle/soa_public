package com.example.crud.service;

import com.example.crud.dto.StudyGroupFilter;
import com.example.crud.dto.StudyGroupRequestDto;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.model.StudyGroup;
import com.example.crud.model.base.BaseEntity;
import com.example.crud.repository.StudyGroupRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudyGroupCrudService {
    private final StudyGroupRepository repository;
    private final ConversionService conversionService;

    public StudyGroupCrudService(StudyGroupRepository repository,
                                 ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    public Page<StudyGroup> getAll(StudyGroupFilter filter) {
        List<String> columnsNames = new ArrayList<>();

        for (Field f:StudyGroup.class.getDeclaredFields()) {
            columnsNames.add(f.getName());
            if (BaseEntity.class.isAssignableFrom(f.getType())) {
                List<String> names = Arrays.stream(f.getType().getDeclaredFields())
                        .map(Field::getName)
                        .collect(Collectors.toList());

                for (String name: names) {
                    columnsNames.add(f.getName() + "." + name);
                }
            }
        }

        List<Sort.Order> orders = new ArrayList<>();

        IntStream.range(0, filter.getOrderBy().size())
                .filter(i -> columnsNames.contains(filter.getOrderBy().get(i)))
                .forEach(i -> {
                    if (filter.getPriority().get(i).equalsIgnoreCase("desc")) {
                        orders.add(Sort.Order.desc(filter.getOrderBy().get(i)));
                    } else {
                        orders.add(Sort.Order.asc(filter.getOrderBy().get(i)));
                    }});

        return repository.findAll(PageRequest.of(filter.getOffset(), filter.getPageSize(), Sort.by(orders)));
    }

    public StudyGroupResponseDto getGroupById(Long id) {
        StudyGroup group = repository.findById(id)
                .orElseThrow(() -> {throw new IllegalArgumentException("group not found by id = " + id);});

        return conversionService.convert(group, StudyGroupResponseDto.class);
    }

    public StudyGroup update(StudyGroup entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    public StudyGroupResponseDto create(StudyGroupRequestDto requestDto) {
        StudyGroup studyGroup = conversionService.convert(requestDto, StudyGroup.class);
        return conversionService.convert(repository.save(studyGroup), StudyGroupResponseDto.class);
    }
}
