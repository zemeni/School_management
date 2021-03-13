package com.babu.schoolmanagement.School_management.controller;

import com.babu.schoolmanagement.School_management.entity.Student;
import com.babu.schoolmanagement.School_management.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;


    @Test
    void addStudent() throws Exception {
        Student student = new Student("Babu", "Neupane", "abc@gmail.com","9740974749");
        String inputInJson = this.mapToJson(student);
        String URI = "/api/school-management/students";

        Mockito.when(studentService.saveStudent(student)).thenReturn(student);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(inputInJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void findStudentById() throws Exception{
        Student student = new Student(1,"Babu","Neupane","acb@gmial.com","96298628");
        Mockito.when(studentService.getStudentById(Mockito.anyInt())).thenReturn(student);
        String URI = "/api/school-management/students/1";
        MockHttpServletRequestBuilder requestBuilders = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilders).andReturn();
        String output = mvcResult.getResponse().getContentAsString();
        String expectedOutput = this.mapToJson(student);
        assertEquals(output, expectedOutput);

    }

    private String mapToJson(Object object) throws JsonProcessingException {
        return (new ObjectMapper().writeValueAsString(object));
    }
}
