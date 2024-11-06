package com.employee.EmployeeDemo.controller;

import com.employee.EmployeeDemo.Domain.dto.EmployeeDTO;
import com.employee.EmployeeDemo.service.serviceImpl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/v1/api/employees")
public class EmployeeController
{

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.updateEmployee(employeeId, employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
    }

}
