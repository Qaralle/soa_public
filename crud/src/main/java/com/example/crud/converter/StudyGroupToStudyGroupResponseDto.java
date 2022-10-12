package com.example.crud.converter;

import com.example.crud.dto.CoordinatesDto;
import com.example.crud.dto.PersonDto;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.model.Coordinates;
import com.example.crud.model.Person;
import com.example.crud.model.StudyGroup;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class StudyGroupToStudyGroupResponseDto implements Converter<StudyGroup, StudyGroupResponseDto> {
    @Override
    public StudyGroupResponseDto convert(StudyGroup source) {
        StudyGroupResponseDto dto = new StudyGroupResponseDto();
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        PersonDto personDto = new PersonDto();

        coordinatesDto.setX(Optional.ofNullable(source.getCoordinates()).map(Coordinates::getX).orElse(null));
        coordinatesDto.setY(Optional.ofNullable(source.getCoordinates()).map(Coordinates::getY).orElse(null));

        personDto.setHairColor(Optional.ofNullable(source.getGroupAdmin())
                .map(Person::getHairColor)
                .orElse(null));
        personDto.setHeight(Optional.ofNullable(source.getGroupAdmin())
                .map(Person::getHeight)
                .orElse(0));
        personDto.setName(Optional.ofNullable(source.getGroupAdmin())
                .map(Person::getName)
                .orElse(null));
        personDto.setPassportID(Optional.ofNullable(source.getGroupAdmin())
                .map(Person::getPassportID)
                .orElse(null));
        personDto.setNationality(Optional.ofNullable(source.getGroupAdmin())
                .map(Person::getNationality)
                .orElse(null));

        dto.setCoordinates(coordinatesDto);
        dto.setGroupAdmin(personDto);
        dto.setName(source.getName());
        dto.setId(source.getId());
        dto.setCreationDate(source.getCreationDate());
        dto.setSemesterEnum(source.getSemesterEnum());
        dto.setFormOfEducation(source.getFormOfEducation());
        dto.setStudentsCount(source.getStudentsCount());
        dto.setShouldBeExpelled(source.getShouldBeExpelled());

        return dto;
    }
}
