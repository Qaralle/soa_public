package com.example.crud.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "studyGroupList")
@XmlAccessorType(XmlAccessType.NONE)
public class StudyGroupList {
    @XmlElement
    private List<StudyGroupResponseDto> groups;
    @XmlElement
    private Long totalSize;

    public List<StudyGroupResponseDto> getGroups() {
        return groups;
    }

    public void setGroups(List<StudyGroupResponseDto> groups) {
        this.groups = groups;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }
}
