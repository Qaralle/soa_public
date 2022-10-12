package com.example.crud.dto;

import com.example.crud.model.FormOfEducation;
import com.example.crud.model.Semester;
import com.example.crud.util.LocalDateTimeXmlAdapter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Map;

@XmlRootElement(name = "filter")
@XmlAccessorType(XmlAccessType.NONE)
public class StudyGroupFilter {
    @XmlElement
    private String name;
    @XmlElement
    private Integer coordinatesX;
    @XmlElement
    private Integer coordinatesY;
    @XmlElement
    @XmlJavaTypeAdapter(value = LocalDateTimeXmlAdapter.class)
    private LocalDateTime creationDate;
    @XmlElement
    private Long studentsCount;
    @XmlElement
    private Long shouldBeExpelled;
    @XmlElement
    private FormOfEducation formOfEducation;
    @XmlElement
    private Semester semesterEnum;
    @XmlElement
    private String groupAdminPassportID;
    @Min(1)
    @XmlElement
    private int pageSize = 10;
    @Min(0)
    @XmlElement
    private int page = 0;
    @XmlElement
    private Map<String, String> orderBy;


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

    public Long getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Long studentsCount) {
        this.studentsCount = studentsCount;
    }

    public Long getShouldBeExpelled() {
        return shouldBeExpelled;
    }

    public void setShouldBeExpelled(Long shouldBeExpelled) {
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

    public String getGroupAdminPassportID() {
        return groupAdminPassportID;
    }

    public void setGroupAdminPassportID(String groupAdminPassportID) {
        this.groupAdminPassportID = groupAdminPassportID;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPage(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setOffset(int offset) {
        this.page = offset;
    }

    public Map<String, String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy( Map<String, String> orderBy) {
        this.orderBy = orderBy;
    }
}
