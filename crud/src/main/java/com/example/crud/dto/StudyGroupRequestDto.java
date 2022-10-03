package com.example.crud.dto;

import com.example.crud.model.FormOfEducation;
import com.example.crud.model.Semester;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "studyGroupRequestDto")
@XmlAccessorType(XmlAccessType.NONE)
public class StudyGroupRequestDto {
    @NotNull
    @NotBlank
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    @XmlElement
    private CoordinatesDto coordinates; //Поле не может быть null
    @Min(0)
    @NotNull
    @XmlElement
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    @Min(0)
    @XmlElement
    private long shouldBeExpelled; //Значение поля должно быть больше 0
    @NotNull
    @XmlElement
    private FormOfEducation formOfEducation; //Поле не может быть null
    @NotNull
    @XmlElement
    private Semester semesterEnum; //Поле не может быть null
    @NotNull
    @XmlElement
    private PersonDto groupAdmin; //Поле не может быть null

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
