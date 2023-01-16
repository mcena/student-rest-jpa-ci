package com.example.studentportal.repository;

import com.example.studentportal.entity.StudentPortal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPortalRepository extends JpaRepository<StudentPortal, Integer> {

    StudentPortal findByid(Integer id);

}
