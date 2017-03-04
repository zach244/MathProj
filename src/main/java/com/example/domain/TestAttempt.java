package com.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zach on 3/4/2017.
 */
@Entity
public class TestAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String attemptName;

    public TestAttempt(String attemptName) {
        this.attemptName = attemptName;
    }

    public TestAttempt() {

    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private TestAttempt testAttempt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttemptName() {
        return attemptName;
    }

    public void setAttemptName(String attemptName) {
        this.attemptName = attemptName;
    }


}
