package com.project.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private  long id;
    private  String name;

    private String email;
    private String password;
    private  String department;
    private String  role;
    private String  city;
    private String salary;



}
