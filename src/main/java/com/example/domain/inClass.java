package com.example.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 2/27/2017.
 */
@Entity
public class inClass implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="inclass_id")
    private int id;
    private String className;
    private int gradeLevel;

    public inClass()
    {

    }
    @OneToMany(mappedBy="className", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Section> classSections = new HashSet<>();

    public Set<Section> getClassSections() {
        return classSections;
    }

    public void setClassSections(Set<Section> classSections) {
        this.classSections = classSections;
    }

    public inClass(String className, int gradeLevel, Set<Section> classSections) {

        this.className = className;
        this.gradeLevel = gradeLevel;
        this.classSections = classSections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

}
