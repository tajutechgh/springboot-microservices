package com.tajutechgh.employeeservice.dto;

public class ApiResponseDto {

    private EmployeeDto employee;
    private DepartmentDto department;

    public ApiResponseDto() {

    }

    public ApiResponseDto(EmployeeDto employee, DepartmentDto department) {
        this.employee = employee;
        this.department = department;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }
}
