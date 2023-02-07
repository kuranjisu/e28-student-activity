package com.example.e28studentactivity.service;

import com.example.e28studentactivity.entity.Course;
import com.example.e28studentactivity.entity.Student;
import com.example.e28studentactivity.repository.CourseRepository;
import com.example.e28studentactivity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }
    public Optional<Student> findStudentById(Long id){
        return studentRepository.findById(id);
    }
    public Student updateStudent(long id, Student student){
        student.setStudentId(id);
        return studentRepository.save(student);
    }
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    public Student enrollStudent(Long id, Course course) {
        Student student = studentRepository.findById(id).get();
        student.getCourses().add(courseRepository.findById(course.getCourseId()).get());
        studentRepository.save(student);
        return student;
    }
    public Student dropStudent(Long id, Course course) {
        Student student=studentRepository.findById(id).get();
        student.getCourses().remove(courseRepository.findById(course.getCourseId()).get());
        studentRepository.save(student);
        return student;
    }


}
