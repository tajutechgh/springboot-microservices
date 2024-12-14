package com.tajutechgh.employeeservice.service;

import com.tajutechgh.employeeservice.dto.ApiResponseDto;
import com.tajutechgh.employeeservice.dto.EmployeeDto;
import com.tajutechgh.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);

    EmployeeDto deleteEmployee(Long employeeId);
}