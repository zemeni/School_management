package com.babu.schoolmanagement.School_management.service;

import com.babu.schoolmanagement.School_management.entity.Student;
import com.babu.schoolmanagement.School_management.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    void saveStudent() {
        Student student = new Student("Babu","Neupane","abc@gmail.com","7309793");
        when(studentRepository.save(student)).thenReturn(student);
        assertThat(studentService.saveStudent(student)).isEqualTo(student);
    }

    @Test
    void getStudentById() {
        Student student = new Student(1,"Babu","Neupane","abc@gmail.com","6298282");
        when(studentRepository.findById(1)).thenReturn(java.util.Optional.of(student));
        assertThat(studentService.getStudentById(1)).isEqualTo(student);
    }

    @Test
    void getAllStudents() {
        Student student = new Student("Babu","Neupane","abc@gmail.com","03097903");
        Student student1 = new Student("Babu","Neupane","abc@gmail.com","39737938");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        when(studentRepository.findAll()).thenReturn(students);
        assertThat(studentService.getStudents()).isEqualTo(students);
    }
}
