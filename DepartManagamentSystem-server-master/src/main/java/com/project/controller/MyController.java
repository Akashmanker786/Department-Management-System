package com.project.controller;

import com.project.Dto.EmployeeDto;
import com.project.payload.ApiRespons;
import com.project.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/emp")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> createEmployee( @Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = this.employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(employee , HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee( @Valid @RequestBody   EmployeeDto employeeDto , @PathVariable  Long id){
        EmployeeDto employee = this.employeeService.updateEmployee(employeeDto  ,id);

        return new ResponseEntity<>(employee , HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee( @PathVariable  Long id){
        EmployeeDto employee = this.employeeService.getEmployee(id);

        return new ResponseEntity<>(employee , HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> allEmployee = this.employeeService.getAllEmployee();

        return new ResponseEntity<>(allEmployee , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiRespons> deleteEmployee( @PathVariable  Long id){
        this.employeeService.deleteEmployee(id);

        return new ResponseEntity<>(new ApiRespons("Employee deleted successfully  " ,true) , HttpStatus.OK);
    }

    //find by key

    @GetMapping("/search/{key}")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeeByTitle( @PathVariable  String key){
        List<EmployeeDto> byKey = this.employeeService.searchEmployee(key);

        return new ResponseEntity<>(byKey , HttpStatus.OK);
    }
}
