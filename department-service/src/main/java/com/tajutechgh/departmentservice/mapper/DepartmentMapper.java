package com.tajutechgh.departmentservice.mapper;

import com.tajutechgh.departmentservice.dto.DepartmentDto;
import com.tajutechgh.departmentservice.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department = new Department(
            departmentDto.getId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription(),
            departmentDto.getDepartmentCode()
        );

        return department;
    }

    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription(),
            department.getDepartmentCode()
        );

        return departmentDto;
    }
}