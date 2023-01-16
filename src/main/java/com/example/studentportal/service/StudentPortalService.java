package com.example.studentportal.service;

import com.example.studentportal.dto.StudentPortalRequest;
import com.example.studentportal.entity.StudentPortal;
import com.example.studentportal.repository.StudentPortalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPortalService {

    private StudentPortalRepository studentPortalRepository;

    @Autowired
    public StudentPortalService(StudentPortalRepository studentPortalRepository) {

        this.studentPortalRepository = studentPortalRepository;

    }

    public ResponseEntity<String> addStudent(StudentPortalRequest studentPortalRequest) {

        StudentPortal studentPortal = new StudentPortal();
        studentPortal.setFirstName(studentPortalRequest.getFirstName());
        studentPortal.setLastName(studentPortalRequest.getLastName());
        studentPortal.setEmail(studentPortalRequest.getEmail());
        studentPortal.setCourse(studentPortalRequest.getCourse());
        studentPortal.setGpa(studentPortalRequest.getGpa());
        studentPortalRepository.save(studentPortal);

        return new ResponseEntity<>("Created", HttpStatus.CREATED);

    }

    public List<StudentPortal> findAllStudent() {

        return studentPortalRepository.findAll();

    }

    public ResponseEntity<StudentPortal> findStudentById(Integer id){

        return new ResponseEntity<>(studentPortalRepository.findByid(id), HttpStatus.OK);

    }

    public StudentPortal updateStudent(Integer id, StudentPortalRequest studentPortalRequest) {

        StudentPortal studentToUpdate = studentPortalRepository.findByid(id);
        studentToUpdate.setFirstName(studentPortalRequest.getFirstName());
        studentToUpdate.setLastName(studentPortalRequest.getLastName());
        studentToUpdate.setEmail(studentPortalRequest.getEmail());
        studentToUpdate.setCourse(studentPortalRequest.getCourse());
        studentToUpdate.setGpa(studentPortalRequest.getGpa());
        studentPortalRepository.save(studentToUpdate);

        return studentToUpdate;

    }

    public void deleteStudent(Integer id) {

        studentPortalRepository.deleteById(id);

    }








}
