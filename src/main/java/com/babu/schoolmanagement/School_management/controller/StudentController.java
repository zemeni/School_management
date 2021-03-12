package com.babu.schoolmanagement.School_management.controller;

import com.babu.schoolmanagement.School_management.entity.Student;
import com.babu.schoolmanagement.School_management.exception.StudentNotFoundException;
import com.babu.schoolmanagement.School_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school-management/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    /*@PostMapping
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }*/

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Student findStudentById(@PathVariable int studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            throw new StudentNotFoundException("student id " + studentId + " not found");
        }
        return student;
    }

    /*@GetMapping("byName/{name}")
    public Student findStudentByName(@PathVariable String name) {
        return studentService.getStudentByEmail(name);
    }*/

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId")
    public String deleteStudent(@PathVariable int studentId) {
        return studentService.deleteStudent(studentId);
    }

}
