package com.example.crud.dto;

import com.example.crud.model.StudyGroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "studyGroupList")
@XmlAccessorType(XmlAccessType.NONE)
public class StudyGroupList {
    @XmlElement
    private List<StudyGroup> groups;
    @XmlElement
    private int totalSize;

    public List<StudyGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<StudyGroup> groups) {
        this.groups = groups;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
