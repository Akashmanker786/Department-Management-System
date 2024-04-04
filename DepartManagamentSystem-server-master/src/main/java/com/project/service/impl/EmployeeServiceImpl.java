package com.project.service.impl;

import com.project.Dao.EmployeeRepo;
import com.project.Dto.EmployeeDto;
import com.project.exception.ResourceNotFoundException;
import com.project.model.Employee;
import com.project.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee emp = this.modelMapper.map(employeeDto, Employee.class);

        Employee saveEmp = this.employeeRepo.save(emp);

        return this.modelMapper.map(saveEmp , EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto updateEmp, Long id) {

        Employee employee = this.employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee id not found :", id));



        employee.setName(updateEmp.getName());
      //  employee.setLastName(updateEmp.getLastName());
        employee.setEmail(updateEmp.getEmail());
        employee.setPassword(updateEmp.getPassword());
        employee.setCity(updateEmp.getCity());
        //employee.setGender(updateEmp.getGender());
        employee.setDepartment(updateEmp.getDepartment());
        employee.setSalary(updateEmp.getSalary());
        employee.setRole(updateEmp.getRole());

        this.employeeRepo.save(employee);

        return this.modelMapper.map(employee , EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {

        Employee employee = this.employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee is not found id : ", id));

        return this.modelMapper.map(employee , EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {

        List<Employee> allEmp = this.employeeRepo.findAll();
        List<EmployeeDto> allDto = allEmp.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
        return allDto;
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = this.employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not fond ", id));

        this.employeeRepo.delete(employee);

    }

    @Override
    public List<EmployeeDto> searchEmployee(String key) {

        List<Employee> byTitleContaining = this.employeeRepo.findByNameContaining(key);
        List<EmployeeDto> allDto = byTitleContaining.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

        return allDto;
    }


}
