package com.example.e28studentactivity.controller;

import com.example.e28studentactivity.entity.Course;
import com.example.e28studentactivity.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/allcourses")
    public List<Course> findAllCourse() {
        return courseService.findAllCourse();
    }

    @GetMapping("/getcourse/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id){
        return courseService.findCourseById(id);
    }

    @PostMapping("/addcourse")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/updatecourse/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setCourseId(id);
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/deletecourse/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }
}
