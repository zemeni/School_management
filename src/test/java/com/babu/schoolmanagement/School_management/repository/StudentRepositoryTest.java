package com.babu.schoolmanagement.School_management.repository;

import com.babu.schoolmanagement.School_management.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

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
    void findByEmail() {
        Student student = new Student(1,"Babu","Neupane","abc@gmail.com");
        Student savedInDb = testEntityManager.merge(student);
        Student fromDb = studentRepository.getOne(savedInDb.getId());
        assertThat(fromDb).isEqualTo(savedInDb);
    }
}
