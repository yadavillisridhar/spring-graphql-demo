package com.demo.service;

import com.demo.controller.StudentRequest;
import com.demo.repo.Students;
import com.demo.repo.StudentsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentsService {

    StudentsRepo studentsRepo;

    @Override
    public List<Students> getStudents() {
        return studentsRepo.findAll();
    }

    @Override
    public Optional<Students> getStudent(Integer studentId) {
        return studentsRepo.findById(studentId);
    }

    @Override
    public Students addStudent(StudentRequest studentRequest) {
        Students stud = Students.builder()
                .studentName(studentRequest.getStudentName())
                .dob(Timestamp.valueOf(studentRequest.getDob()))
                .build();
        return studentsRepo.save(stud);
    }
}
