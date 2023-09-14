package com.employee.Employee.SpringBootProject.serviceImpl;

import com.employee.Employee.SpringBootProject.model.Employee;
import com.employee.Employee.SpringBootProject.repository.EmployeeRepository;
import com.employee.Employee.SpringBootProject.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService
{

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public Employee add(Employee emp)
    {
        log.info("Employee Details that is being added {}", emp);
        return empRepo.save(emp);
    }

    @Override
    public Optional<Employee> get(int empid)
    {
        log.info("Request received to search employee with Id {} ", empid);
        Optional<Employee> empDetails = empRepo.findById(empid);
        if (empDetails.isEmpty())
        {
            return null;
        }
        return empDetails;
    }

    @Override
    public List<Employee> getAll()
    {
        log.info("Request received to show all employee details");
        return empRepo.findAll();
    }

    @Override
    public Employee update(Employee emp, int id)
    {
        Optional<Employee> employee = empRepo.findById(id);
        if (!employee.isEmpty())
        {
            Employee newEmp = Employee.builder().id(id).firstName(emp.getFirstName()).lastName(emp.getLastName())
                    .salary(emp.getSalary()).phoneNumber(emp.getPhoneNumber()).age(emp.getAge()).city(emp.getCity())
                    .pinCode(emp.getPinCode()).build();
            empRepo.save(newEmp);
            log.info("Request received to update employee having employee id as {} having new details are {}",
                    emp.getId(), emp);
            return newEmp;
        }
        else
        {
            log.info("Given input employee id is not found");
            return null;
        }
    }

    @Override
    public void delete(int empid)
    {
        log.info("Employee having employee id {} is deleted", empid);
        empRepo.deleteById(empid);
    }
    @Override
    public List<Employee> findByFirstName(String firstName)
    {
        List<Employee> employees = empRepo.findByFirstName(firstName);
        return employees;
    }
    @Override
    public List<Employee> findByLastName(String lastName)
    {
        List<Employee> employees = empRepo.findByLastName(lastName);
        return employees;
    }
    @Override
    public List<Employee> findByAge(int age)
    {
        List<Employee> employeeList = empRepo.findEmpByAge(age);
        return employeeList;
    }

}
