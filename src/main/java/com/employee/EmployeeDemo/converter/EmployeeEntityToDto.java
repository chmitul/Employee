package com.employee.EmployeeDemo.converter;

import com.employee.EmployeeDemo.Domain.dto.EmployeeDTO;
import com.employee.EmployeeDemo.Domain.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeEntityToDto
{

    public EmployeeDTO entityToDto(EmployeeEntity emp)
    {

        return EmployeeDTO.builder().employeeId(emp.getEmployeeId()).birthDate(emp.getBirthDate())
                .firstName(emp.getFirstName()).lastName(emp.getLastName()).hireDate(emp.getHireDate())
                .gender(emp.getGender()).build();

    }

    // Convert a list of EmployeeEntity to a list of EmployeeDto using streams
    public List<EmployeeDTO> convertToDtoList(List<EmployeeEntity> employeeEntityList)
    {
        return employeeEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
