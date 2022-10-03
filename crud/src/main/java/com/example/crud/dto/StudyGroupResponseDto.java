package com.example.crud.dto;

import com.example.crud.model.Coordinates;
import com.example.crud.model.FormOfEducation;
import com.example.crud.model.Person;
import com.example.crud.model.Semester;
import com.example.crud.util.LocalDateTimeXmlAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name = "studyGroupResponseDto")
@XmlAccessorType(XmlAccessType.NONE)
public class StudyGroupResponseDto {
    @XmlElement
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private CoordinatesDto coordinates; //Поле не может быть null
    @XmlElement
    @XmlJavaTypeAdapter(value = LocalDateTimeXmlAdapter.class)
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
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