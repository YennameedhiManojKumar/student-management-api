package com.manoj.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manoj.student_management.entity.Student;
import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findByCourse(String course);
    Optional<Student> findByEmail(String email);
    List<Student> findByNameContainingIgnoreCase(String name);
}
