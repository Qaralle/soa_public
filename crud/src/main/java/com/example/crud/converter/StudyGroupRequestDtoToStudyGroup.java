package com.example.crud.converter;

import com.example.crud.dto.CoordinatesDto;
import com.example.crud.dto.PersonDto;
import com.example.crud.dto.StudyGroupRequestDto;
import com.example.crud.dto.StudyGroupResponseDto;
import com.example.crud.model.Coordinates;
import com.example.crud.model.Person;
import com.example.crud.model.StudyGroup;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudyGroupRequestDtoToStudyGroup  implements Converter<StudyGroupRequestDto, StudyGroup> {
    @Override
    public StudyGroup convert(StudyGroupRequestDto source) {
        StudyGroup studyGroup = new StudyGroup();
        Coordinates coordinates = new Coordinates();
        Person admin = new Person();

        coordinates.setX(Optional.ofNullable(source.getCoordinates())
                .map(CoordinatesDto::getX)
                .orElse(null));
        coordinates.setY(Optional.ofNullable(source.getCoordinates())
                .map(CoordinatesDto::getY)
                .orElse(null));

        admin.setHairColor(Optional.ofNullable(source.getGroupAdmin())
                .map(PersonDto::getHairColor)
                .orElse(null));
        admin.setHeight(Optional.ofNullable(source.getGroupAdmin())
                .map(PersonDto::getHeight)
                .orElse(0));
        admin.setName(Optional.ofNullable(source.getGroupAdmin())
                .map(PersonDto::getName)
                .orElse(null));
        admin.setPassportID(Optional.ofNullable(source.getGroupAdmin())
                .map(PersonDto::getPassportID)
                .orElse(null));
        admin.setNationality(Optional.ofNullable(source.getGroupAdmin())
                .map(PersonDto::getNationality)
                .orElse(null));

        studyGroup.setGroupAdmin(admin);
        studyGroup.setCoordinates(coordinates);

        studyGroup.setName(source.getName());
        studyGroup.setFormOfEducation(source.getFormOfEducation());
        studyGroup.setSemesterEnum(source.getSemesterEnum());
        studyGroup.setShouldBeExpelled(source.getShouldBeExpelled());
        studyGroup.setStudentsCount(source.getStudentsCount());

        return studyGroup;
    }
}
