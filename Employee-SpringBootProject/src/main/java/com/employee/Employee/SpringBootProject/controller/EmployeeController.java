package com.employee.Employee.SpringBootProject.controller;

import com.employee.Employee.SpringBootProject.model.Employee;
import com.employee.Employee.SpringBootProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee add(@RequestBody Employee emp) {
        return empService.add(emp);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Employee> get(@PathVariable int id) {
        Optional<Employee> emp = empService.get(id);
        return emp;
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAll() {
        List<Employee> listOfEmployees = empService.getAll();
        return listOfEmployees;
    }

    @DeleteMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable int id) {
        empService.delete(id);
        return "Employee Deleted successfully";
    }

    @PutMapping(value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@RequestBody Employee emp,@PathVariable int id){
        Employee employee = empService.update(emp,id);
        return employee ;
    }

    @GetMapping(value = "/byfirstname/{firstName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findByFirstName(@PathVariable String firstName){
        List<Employee> employees = empService.findByFirstName(firstName) ;
        return employees ;
    }

    @GetMapping(value = "/bylastname/{lastName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findByLastName(@PathVariable String lastName){
        List<Employee> employees = empService.findByLastName(lastName) ;
        return employees ;
    }

    @GetMapping(value = "findbyage/{age}")
    public List<Employee> findByAge(@PathVariable int age){
        List<Employee> employeesList = empService.findByAge(age);
        return employeesList;
    }

}
