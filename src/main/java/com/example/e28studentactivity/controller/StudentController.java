package com.example.e28studentactivity.controller;

import com.example.e28studentactivity.entity.Course;
import com.example.e28studentactivity.entity.Student;
import com.example.e28studentactivity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/allstudents")
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("/getstudent/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @PostMapping("/addstudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/updatestudent/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setStudentId(id);
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/deletestudent/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
    @PutMapping("/students/{id}/enroll")
    public Student enrollStudent(@PathVariable("id") Long id, @RequestBody Course course) {
        return studentService.enrollStudent(id, course);
    }

    @DeleteMapping("/students/{id}/drop")
    public Student dropStudent(@PathVariable("id") Long id, @RequestBody Course course) {
        studentService.dropStudent(id, course);
        return studentService.dropStudent(id,course);
    }


}
