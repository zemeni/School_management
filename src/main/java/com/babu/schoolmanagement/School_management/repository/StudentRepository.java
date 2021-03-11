package com.babu.schoolmanagement.School_management.repository;

import com.babu.schoolmanagement.School_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByEmail(String name);
}
