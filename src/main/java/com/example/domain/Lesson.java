package com.example.domain;

import javax.persistence.*;

/**
 * Created by ZACH on 2/28/2017.
 */
@Entity
public class Lesson implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(referencedColumnName = "inclass_id")
    private inClass inClass;

    public Lesson(String name, String description, com.example.domain.inClass inClass) {
        this.name = name;
        this.description = description;
        this.inClass = inClass;
    }
    public Lesson()
    {

    }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.example.domain.inClass getInClass() {
        return inClass;
    }

    public void setInClass(com.example.domain.inClass inClass) {
        this.inClass = inClass;
    }
}
