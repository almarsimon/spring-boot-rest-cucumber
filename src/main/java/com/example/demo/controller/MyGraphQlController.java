package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyGraphQlController {

    @GetMapping("employees")
    public String employees() {
        return "v1.0.0";
    }

}
