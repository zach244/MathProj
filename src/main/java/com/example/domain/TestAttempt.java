package com.example.domain;

import javax.persistence.*;
import java.util.Date;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private Test test;
    @OneToMany(mappedBy = "testAttempt", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AnswerAttempt> answerAttempts = new HashSet<>();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP_FIELD")
    private java.util.Date timestampField;


    public TestAttempt() {

    }

    public TestAttempt(User user, Test test, Date timestampField) {
        this.user = user;
        this.test = test;
        this.timestampField = timestampField;
    }

    public TestAttempt(User user, Test test) {
        this.user = user;
        this.test = test;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Set<AnswerAttempt> getAnswerAttempts() {
        return answerAttempts;
    }

    public void setAnswerAttempts(Set<AnswerAttempt> answerAttempts) {
        this.answerAttempts = answerAttempts;
    }

    @Override
    public String toString() {
        return "TestAttempt{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", test=" + test.toString() +
                '}';
    }
}
