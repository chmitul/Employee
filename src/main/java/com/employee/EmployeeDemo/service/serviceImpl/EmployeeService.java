package com.employee.EmployeeDemo.service.serviceImpl;
import com.employee.EmployeeDemo.Domain.dto.EmployeeDTO;
import com.employee.EmployeeDemo.Domain.entity.EmployeeEntity;
import com.employee.EmployeeDemo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper)
    {
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO)
    {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setHireDate(employeeDTO.getHireDate());
        employeeMapper.insertEmployee(employee);
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        return employeeDTO;
    }

    public EmployeeDTO getEmployeeById(Long employeeId)
    {
        return employeeMapper.getEmployeeById(employeeId);
    }

    public List<EmployeeDTO> getAllEmployees()
    {
        return employeeMapper.getAllEmployees();
    }

    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO)
    {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmployeeId(employeeId);
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setHireDate(employeeDTO.getHireDate());
        employeeMapper.updateEmployee(employee);
        return employeeDTO;
    }

    public void deleteEmployee(Long employeeId)
    {
        employeeMapper.deleteEmployee(employeeId);
    }
}
