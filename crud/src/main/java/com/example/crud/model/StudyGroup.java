package com.example.crud.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "study_group")
public class StudyGroup {
    @Min(0)
    private Long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NotNull
    @NotBlank
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    private Coordinates coordinates; //Поле не может быть null
    @NotNull
    @CreationTimestamp
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @Min(0)
    @NotNull
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    @Min(0)
    private long shouldBeExpelled; //Значение поля должно быть больше 0
    @NotNull
    private FormOfEducation formOfEducation; //Поле не может быть null
    @NotNull
    private Semester semesterEnum; //Поле не может быть null
    @NotNull
    private Person groupAdmin; //Поле не может быть null

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "coordinates_id")
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Column(name = "creation_date")
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "student_count")
    public Long getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Long studentsCount) {
        this.studentsCount = studentsCount;
    }

    @Column(name = "should_be_expelled")
    public long getShouldBeExpelled() {
        return shouldBeExpelled;
    }

    public void setShouldBeExpelled(long shouldBeExpelled) {
        this.shouldBeExpelled = shouldBeExpelled;
    }

    @Column(name = "education_form")
    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    @Column(name = "semester")
    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }
}