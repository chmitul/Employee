package com.employee.EmployeeDemo.mapper;
import com.employee.EmployeeDemo.Domain.dto.EmployeeDTO;
import com.employee.EmployeeDemo.Domain.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper
{

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    void insertEmployee(EmployeeEntity employee);

    void updateEmployee(EmployeeEntity employee);

    void deleteEmployee(Long employeeId);

    Long getNextId() ;
}
