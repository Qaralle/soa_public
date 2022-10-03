package com.example.crud.dto;

import com.example.crud.model.FormOfEducation;
import com.example.crud.model.Semester;

import java.time.LocalDateTime;
import java.util.List;

public class StudyGroupFilter {
    private Long id;
    private String name;
    private Integer coordinatesX;
    private Integer coordinatesY;
    private LocalDateTime creationDate;
    private int studentsCount;
    private int shouldBeExpelled;
    private FormOfEducation formOfEducation;
    private Semester semesterEnum;
    private PersonDto groupAdminPassportID;
    private int pageSize;
    private int offset;
    private List<String> orderBy;
    private List<String> priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(Integer coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public Integer getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(Integer coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getShouldBeExpelled() {
        return shouldBeExpelled;
    }

    public void setShouldBeExpelled(int shouldBeExpelled) {
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

    public PersonDto getGroupAdminPassportID() {
        return groupAdminPassportID;
    }

    public void setGroupAdminPassportID(PersonDto groupAdminPassportID) {
        this.groupAdminPassportID = groupAdminPassportID;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(List<String> orderBy) {
        this.orderBy = orderBy;
    }

    public List<String> getPriority() {
        return priority;
    }

    public void setPriority(List<String> priority) {
        this.priority = priority;
    }
}
