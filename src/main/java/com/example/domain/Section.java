package com.example.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ZACH on 2/23/2017.
 */
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private DateTimeFormat sectionTime;
    private String sectionRoom;
    private String teacher;
    //need mapping between section and class
    public Section(DateTimeFormat sectionTime, String sectionRoom, String teacher) {
        this.sectionTime = sectionTime;
        this.sectionRoom = sectionRoom;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTimeFormat getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(DateTimeFormat sectionTime) {
        this.sectionTime = sectionTime;
    }

    public String getSectionRoom() {
        return sectionRoom;
    }

    public void setSectionRoom(String sectionRoom) {
        this.sectionRoom = sectionRoom;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


}
