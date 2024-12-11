package com.tajutechgh.departmentservice.service;

import com.tajutechgh.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentCode);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto);

    DepartmentDto deleteDepartment(Long departmentId);
}