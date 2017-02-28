package com.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 2/24/2017.
 */
@Entity

public class Section implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="section_id")
    private int id;
    private String sectionName;
    private int sectionTime;
    private String teacherFirst;
    private String teacherLast;


    public Section()
    {

    }
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    @ManyToOne
    @JoinColumn(referencedColumnName = "inclass_id")
    private inClass className;

    public inClass getClassName() {
        return className;
    }

    public void setClassName(inClass className) {
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }

    public String getTeacherFirst() {
        return teacherFirst;
    }

    public void setTeacherFirst(String teacherFirst) {
        this.teacherFirst = teacherFirst;
    }

    public String getTeacherLast() {
        return teacherLast;
    }

    public void setTeacherLast(String teacherLast) {
        this.teacherLast = teacherLast;
    }


}
