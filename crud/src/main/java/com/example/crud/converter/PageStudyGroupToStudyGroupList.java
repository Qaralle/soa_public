package com.example.crud.converter;

import com.example.crud.dto.StudyGroupList;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.util.sort.Page;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageStudyGroupToStudyGroupList implements Converter<Page<StudyGroupResponseDto>, StudyGroupList> {

    @Override
    public StudyGroupList convert(Page<StudyGroupResponseDto> source) {
        StudyGroupList list = new StudyGroupList();

        list.setGroups(source.getData());
        list.setTotalSize(source.getTotalSize());

        return list;
    }
}
