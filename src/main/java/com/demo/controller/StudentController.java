package com.demo.controller;

import com.demo.repo.Students;
import com.demo.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class StudentController {

    StudentsService studentsService;

    @QueryMapping
    public Students getStudent(@Argument Integer id) {
        Optional<Students> studentsOpt = studentsService.getStudent(id);
        return studentsOpt.orElse(null);
    }

    @QueryMapping
    public List<Students> getStudents() {
        return studentsService.getStudents();
    }

    @MutationMapping
    public Students addStudent(@Argument StudentRequest studentRequest) {
        return studentsService.addStudent(studentRequest);
    }

}
