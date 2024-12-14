package com.tajutechgh.employeeservice.service;

import com.tajutechgh.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", name = "DEPARTMENT-SERVICE")
public interface ApiClient {
    // Build get department rest api
    @GetMapping("api/departments/get/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}