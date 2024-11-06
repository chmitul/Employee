package com.employee.EmployeeDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.employee.EmployeeDemo.mapper")
@SpringBootApplication(scanBasePackages = "com.employee.EmployeeDemo")
public class EmployeeDemoApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(EmployeeDemoApplication.class, args);
    }

}
