package com.manoj.student_management.service;

import com.manoj.student_management.dto.StudentRequest;
import com.manoj.student_management.dto.StudentResponse;
import com.manoj.student_management.entity.Student;
import com.manoj.student_management.exception.StudentNotFoundException;
import com.manoj.student_management.repository.StudentRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public StudentResponse createStudent(StudentRequest request) {

        Student student = new Student();

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());
        student.setCourse(request.getCourse());

        Student savedStudent = studentRepository.save(student);

        return mapToResponse(savedStudent);
    }

    // GET ALL
    public Page<StudentResponse> getAllStudents(Pageable pageable) {

        return studentRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    // GET BY ID
    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student not found with id: " + id));

        return mapToResponse(student);
    }

    // UPDATE
    public StudentResponse updateStudent(
            Long id,
            StudentRequest request) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student not found with id: " + id));

        existingStudent.setName(request.getName());
        existingStudent.setEmail(request.getEmail());
        existingStudent.setAge(request.getAge());
        existingStudent.setCourse(request.getCourse());

        Student updatedStudent = studentRepository.save(existingStudent);

        return mapToResponse(updatedStudent);
    }

    // DELETE
    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(
                    "Student not found with id: " + id);
        }

        studentRepository.deleteById(id);
    }

    public List<StudentResponse> getStudentsByCourse(String course) {

        return studentRepository.findByCourse(course)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<StudentResponse> searchStudents(String name) {

        return studentRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ENTITY → RESPONSE DTO
    private StudentResponse mapToResponse(Student student) {

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getCourse());
    }
}