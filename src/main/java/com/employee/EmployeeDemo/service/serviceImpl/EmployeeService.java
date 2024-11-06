package com.employee.EmployeeDemo.service.serviceImpl;

import ch.qos.logback.core.util.StringUtil;
import com.employee.EmployeeDemo.Domain.dto.EmployeeDTO;
import com.employee.EmployeeDemo.Domain.entity.EmployeeEntity;
import com.employee.EmployeeDemo.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
		employee.setEmployeeId(getNextId());
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
		EmployeeDTO employeeDetails = employeeMapper.getEmployeeById(employeeId);
		if (!StringUtil.isNullOrEmpty(employeeDetails.getFirstName()))
		{
			log.info("Employee with Id {} is found in Database", employeeId);
			return employeeDetails;
		}
		else
		{
			log.error("Employee with Id :{} is not found in database", employeeId);
			return null;
		}
	}

	public List<EmployeeDTO> getAllEmployees()
	{

		return employeeMapper.getAllEmployees();
	}

	public String updateEmployee(Long employeeId, EmployeeDTO employeeDTO)
	{

		EmployeeDTO employeeDetails = getEmployeeById(employeeId);

		if (!StringUtil.isNullOrEmpty(employeeDetails.getFirstName()))
		{
			EmployeeEntity employee = new EmployeeEntity();
			employee.setEmployeeId(employeeId);
			employee.setBirthDate(employeeDTO.getBirthDate());
			employee.setFirstName(employeeDTO.getFirstName());
			employee.setLastName(employeeDTO.getLastName());
			employee.setGender(employeeDTO.getGender());
			employee.setHireDate(employeeDTO.getHireDate());
			employeeMapper.updateEmployee(employee);

			return "Employee Updated";
		}
		else
		{
			log.warn("Employee with id:{} is not found to update", employeeId);

			return "Employee not found to Update";
		}
	}

	public void deleteEmployee(Long employeeId)
	{
		EmployeeDTO employee = getEmployeeById(employeeId);

		if (!StringUtil.isNullOrEmpty(employee.getFirstName()))
		{
			employeeMapper.deleteEmployee(employeeId);
		}
		else
		{
			log.warn("Employee with id:{} is not found to delete", employeeId);
		}
	}

	public Long getNextId() {
		return employeeMapper.getNextId();
	}
}
