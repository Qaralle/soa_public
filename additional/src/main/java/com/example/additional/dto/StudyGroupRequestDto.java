package com.example.additional.dto;


import com.example.additional.model.FormOfEducation;
import com.example.additional.model.Semester;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "studyGroupRequestDto")
@XmlAccessorType(XmlAccessType.NONE)
public class StudyGroupRequestDto {
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private CoordinatesDto coordinates; //Поле не может быть null
    @XmlElement
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    @XmlElement
    private long shouldBeExpelled; //Значение поля должно быть больше 0
    @XmlElement
    private FormOfEducation formOfEducation; //Поле не может быть null
    @XmlElement
    private Semester semesterEnum; //Поле не может быть null
    @XmlElement
    private PersonDto groupAdmin; //Поле не может быть null

    public StudyGroupRequestDto() {
    }

    public StudyGroupRequestDto(StudyGroupResponseDto studyGroupResponseDto) {
        name = studyGroupResponseDto.getName();
        coordinates = studyGroupResponseDto.getCoordinates();
        studentsCount = studyGroupResponseDto.getStudentsCount();
        shouldBeExpelled = studyGroupResponseDto.getShouldBeExpelled();
        formOfEducation = studyGroupResponseDto.getFormOfEducation();
        semesterEnum = studyGroupResponseDto.getSemesterEnum();
        groupAdmin = studyGroupResponseDto.getGroupAdmin();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordinatesDto getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesDto coordinates) {
        this.coordinates = coordinates;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Long studentsCount) {
        this.studentsCount = studentsCount;
    }

    public long getShouldBeExpelled() {
        return shouldBeExpelled;
    }

    public void setShouldBeExpelled(long shouldBeExpelled) {
        this.shouldBeExpelled = shouldBeExpelled;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    public PersonDto getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(PersonDto groupAdmin) {
        this.groupAdmin = groupAdmin;
    }
}