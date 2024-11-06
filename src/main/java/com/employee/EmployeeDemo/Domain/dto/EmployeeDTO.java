package com.employee.EmployeeDemo.Domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.ZonedDateTime;
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class EmployeeDTO
{
    private Long employeeId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

}
