package com.example.domain;

import javax.persistence.*;

/**
 * Created by zach on 2/27/2017.
 */
@Entity
public class studentAnswer implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="studentAnswer_id")
    private int id;
    private int answer;
    
}
