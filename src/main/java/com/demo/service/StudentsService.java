package com.demo.service;

import com.demo.controller.StudentRequest;
import com.demo.repo.Students;

import java.util.List;
import java.util.Optional;

public interface StudentsService {

    List<Students> getStudents();

    Optional<Students> getStudent(Integer studentId);

    Students addStudent(StudentRequest studentRequest);

}
