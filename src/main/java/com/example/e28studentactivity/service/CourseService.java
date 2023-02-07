package com.example.e28studentactivity.service;

import com.example.e28studentactivity.entity.Course;
import com.example.e28studentactivity.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    public List<Course> findAllCourse(){
        return courseRepository.findAll();
    }
    public Optional<Course> findCourseById(Long id){
        return courseRepository.findById(id);
    }
    public Course updateCourse(long id, Course course){
        course.setCourseId(id);
        return courseRepository.save(course);
    }
    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }
}
