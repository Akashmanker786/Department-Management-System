package com.project.Dao;

import com.project.Dto.EmployeeDto;
import com.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee  , Long> {

    Optional<Employee> findByEmail(String username);
  public  List<Employee> findByNameContaining(String title);


}
