package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
    private String name;
    private String birthdate;
    private Department department;
}
