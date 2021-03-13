package com.babu.schoolmanagement.School_management.service;

import com.babu.schoolmanagement.School_management.entity.Student;
import com.babu.schoolmanagement.School_management.repository.StudentRepository;
import com.babu.schoolmanagement.School_management.utils.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PhoneNumberValidator phoneNumberValidator;

    public Student saveStudent(Student student) {
        if(!phoneNumberValidator.test(student.getPhoneNumber()))
            throw new IllegalStateException("Phone Number Not Valid");
        return studentRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(null);
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Student id::"+id+"  deleted";
    }

    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        if (existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
        }
        return studentRepository.save(existingStudent);
    }
}
