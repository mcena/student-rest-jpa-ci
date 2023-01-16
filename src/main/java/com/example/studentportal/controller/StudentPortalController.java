package com.example.studentportal.controller;

import com.example.studentportal.dto.StudentPortalRequest;
import com.example.studentportal.entity.StudentPortal;
import com.example.studentportal.service.StudentPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentPortalController {

    private StudentPortalService studentPortalService;

    @Autowired
    public StudentPortalController(StudentPortalService studentPortalService) {

        this.studentPortalService = studentPortalService;

    }

    @PostMapping("/addStudent")
    public ResponseEntity<String> createTask(@RequestBody StudentPortalRequest studentPortalRequest) {

        studentPortalService.addStudent(studentPortalRequest);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);

    }

    @GetMapping("/findAllStudent")
    public @ResponseBody List<StudentPortal> findAllStudent() {
        return studentPortalService.findAllStudent();
    }

    @GetMapping("/findStudentById")
    public ResponseEntity<StudentPortal> findStudentById(@RequestParam Integer id)
    {
        return studentPortalService.findStudentById(id);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<StudentPortal> updateStudent(@RequestParam Integer id, @RequestBody StudentPortalRequest studentPortalRequest) {

        StudentPortal studentPortal = studentPortalService.updateStudent(id, studentPortalRequest);
        return new ResponseEntity<>(studentPortal, HttpStatus.OK);

    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam(name="id") Integer id) {
        studentPortalService.deleteStudent(id);
        return new ResponseEntity<>("Student Deleted Successfully", HttpStatus.OK);
    }








}
