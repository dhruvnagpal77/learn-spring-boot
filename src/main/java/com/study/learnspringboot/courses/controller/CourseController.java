package com.study.learnspringboot.courses.controller;

import com.study.learnspringboot.courses.bean.Courses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Courses> getAllCourses() {
        return Arrays.asList(new Courses(1, "Course 1", "Dhruv"),new Courses(2, "Course 2", "Dhruv"));
    }

    @GetMapping("/courses/1")
    public Courses getCourseDetails() {
        return new Courses(1, "Course 1", "Dhruv");
    }
}