package com.babu.schoolmanagement.School_management.repository;

import com.babu.schoolmanagement.School_management.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;
    //entity manager automatically takes care of the transaction

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudent() {
        Student student = new Student("Babu","Neupane","abc@gmail.com");
        Student savedInDb = testEntityManager.persist(student);
        Student fromDb = studentRepository.getOne(savedInDb.getId());
        assertThat(fromDb).isEqualTo(savedInDb);
    }

    @Test
    void findByEmail(){
        Student student = new Student("Babu","Neupane","abc@gmail.com");
        Student savedInDb = testEntityManager.persist(student);
        Student fromDb = studentRepository.findByEmail("abc@gmail.com");
        assertThat(savedInDb).isEqualTo(fromDb);
    }

    @Test
    void findById(){
        Student student1 = new Student("abc","bcd","doid");
        Student savedInDb = testEntityManager.persist(student1);
        Student fromDb = studentRepository.getOne(savedInDb.getId());
        assertThat(fromDb).isEqualTo(savedInDb);
    }

    @Test
    void findAll(){
        Student student2 = new Student("Baburam","Neupane","bcd@gmail.com");
        Student student3 = new Student("Baburam","Neupane","bcd@gmail.com");
        Student savedInDb1 = testEntityManager.persist(student3);
        Student savedInDb2 = testEntityManager.persist(student2);
        List<Student> allFromDb = studentRepository.findAll();
        assertThat(allFromDb.size()).isEqualTo(2);
    }

}
