package com.employee.Employee.SpringBootProject.service;

import com.employee.Employee.SpringBootProject.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    
        Optional<Employee> get(int empid) ;

        List<Employee> getAll();

        Employee update(Employee Emp, int id);

        Employee add(Employee emp);

        void delete(int empid) ;

        List<Employee> findByFirstName(String firstName);

        List<Employee> findByLastName(String lastName);

        List<Employee> findByAge(int age);
}
