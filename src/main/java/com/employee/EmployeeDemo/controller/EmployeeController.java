package com.employee.EmployeeDemo.controller;

import com.employee.EmployeeDemo.Domain.dto.EmployeeDTO;
import com.employee.EmployeeDemo.service.serviceImpl.EmployeeService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class EmployeeController
{

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}

	@PostMapping(value = "/create")
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO)
	{
		return employeeService.createEmployee(employeeDTO);
	}

	@GetMapping("/{employeeId}")
	public EmployeeDTO getEmployeeById(@PathVariable Long employeeId)
	{
		log.info("Fetch employee details for employee id :{}", employeeId);
		return employeeService.getEmployeeById(employeeId);
	}

	@GetMapping(value = "/get-all")
	public List<EmployeeDTO> getAllEmployees()
	{
		log.info("Fetching all Employee details.");
		return employeeService.getAllEmployees();
	}

	@PutMapping("/{employeeId}")
	public String updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDTO)
	{
		log.info("Update request to update the employee having Id :{} having values :{}", employeeId, employeeDTO);
		return employeeService.updateEmployee(employeeId, employeeDTO);
	}

	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(@PathVariable Long employeeId)
	{
		log.info("Delete Request to delete the employee with Id :{}", employeeId);
		employeeService.deleteEmployee(employeeId);
	}

}
