package com.example.studentportal.dto;


import lombok.Data;

@Data
public class StudentPortalRequest {

    private String firstName;
    private String lastName;
    private String course;
    private String email;
    private Double gpa;

}
