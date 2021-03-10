package com.babu.schoolmanagement.School_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class FunRestController {

    @GetMapping
    public String test() {
        return "The time on the server is --" + LocalTime.now();
    }
}
