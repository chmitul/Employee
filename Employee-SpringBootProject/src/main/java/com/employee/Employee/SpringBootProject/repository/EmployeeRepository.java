package com.employee.Employee.SpringBootProject.repository;

import com.employee.Employee.SpringBootProject.model.Employee;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    @Query(value = "SELECT * FROM employee e WHERE e.age = :age ", nativeQuery = true)
    List<Employee> findEmpByAge(@Param("age") Integer age);
    
}
