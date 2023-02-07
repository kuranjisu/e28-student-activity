package com.example.e28studentactivity.repository;

import com.example.e28studentactivity.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
