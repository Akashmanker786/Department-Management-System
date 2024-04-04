package com.project.service;

import com.project.Dto.EmployeeDto;
import com.project.model.Employee;

import java.util.List;

public interface EmployeeService {
    //create
    public EmployeeDto createEmployee(EmployeeDto employeeSto);

    // update
    EmployeeDto updateEmployee(EmployeeDto employeeDto , Long id);

    //get

    EmployeeDto getEmployee(Long id);

    List<EmployeeDto> getAllEmployee();

    //delete employee

    void deleteEmployee(Long id);

    //find by key

    List<EmployeeDto> searchEmployee(String key);

    //List<EmployeeDto> findByKey(String key);
}
