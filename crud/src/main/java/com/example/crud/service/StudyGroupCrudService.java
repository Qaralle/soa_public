package com.example.crud.service;

import com.example.crud.dto.StudyGroupFilter;
import com.example.crud.dto.StudyGroupList;
import com.example.crud.dto.StudyGroupRequestDto;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.model.Person;
import com.example.crud.model.StudyGroup;
import com.example.crud.repository.StudyGroupRepository;
import com.example.crud.service.exception.NotFoundByIdException;
import com.example.crud.util.sort.Page;
import org.springframework.core.convert.ConversionService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.crud.util.sort.FilterUtils.getOrdersByNames;

@Service
public class StudyGroupCrudService {
    private final StudyGroupRepository repository;
    private final ConversionService conversionService;
    private final PersonService personService;


    public StudyGroupCrudService(StudyGroupRepository repository,
                                 ConversionService conversionService,
                                 PersonService personService) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.personService = personService;
    }

    public StudyGroupList getAll(StudyGroupFilter filter) {
        List<Sort.Order> orders = getOrdersByNames(filter.getOrderBy());

        Page<StudyGroup> page = repository.findAllByPredicate(filter,
                PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(orders)));

        Page<StudyGroupResponseDto> dtoPage = new Page<>();

        List<StudyGroupResponseDto> dtoList = page.getData().stream()
                .map(studyGroup -> conversionService.convert(studyGroup, StudyGroupResponseDto.class))
                .collect(Collectors.toList());

        dtoPage.setData(dtoList);
        dtoPage.setTotalSize(page.getTotalSize());

        return conversionService.convert(dtoPage, StudyGroupList.class);
    }

    public StudyGroupResponseDto getGroupById(Long id) {
        StudyGroup group = repository.findById(id)
                .orElseThrow(() -> {throw new NotFoundByIdException("group not found by id = " + id);});

        return conversionService.convert(group, StudyGroupResponseDto.class);
    }

    public StudyGroupResponseDto update(Long id, StudyGroupRequestDto requestDto) {
        StudyGroup studyGroup = conversionService.convert(requestDto, StudyGroup.class);

        StudyGroup based = repository.findById(id).orElse(null);

        if (based!=null){
            studyGroup.setId(id);
            studyGroup.setCreationDate(based.getCreationDate());
        }

        return  conversionService.convert(repository.save(studyGroup), StudyGroupResponseDto.class);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NotFoundByIdException("group not found by id = " + id);
        }
    }

    public StudyGroupResponseDto create(StudyGroupRequestDto requestDto) {
        StudyGroup studyGroup = conversionService.convert(requestDto, StudyGroup.class);

        return conversionService.convert(repository.save(studyGroup), StudyGroupResponseDto.class);
    }

}
