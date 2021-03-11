package com.babu.schoolmanagement.School_management.controller;

import com.babu.schoolmanagement.School_management.entity.Student;
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

    @PostMapping("/all")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Student findStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    /*@GetMapping("byName/{name}")
    public Student findStudentByName(@PathVariable String name) {
        return studentService.getStudentByEmail(name);
    }*/

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }

}
