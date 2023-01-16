package com.example.studentportal.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student_portal")
public class StudentPortal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String course;
    private String email;
    private Double gpa;



}
