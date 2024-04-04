package com.project.payload;

import com.project.Dto.EmployeeDto;
import com.project.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class AuthenticationResponse {
    private String token;
    private String message;

    private EmployeeDto employee;

    public AuthenticationResponse(String token, String message , EmployeeDto employeeDto) {
        this.token = token;
        this.message = message;
        this.employee = employeeDto;
    }

//    public String getToken() {
//        return token;
//    }
//
//    public String getMessage() {
//        return message;
//    }
}
