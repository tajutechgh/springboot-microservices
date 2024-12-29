package com.tajutechgh.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "API Response")
public class ApiResponseDto {

    @Schema(description = "Employee Details")
    private EmployeeDto employee;

    @Schema(description = "Department Details")
    private DepartmentDto department;

    @Schema(description = "Organization Details")
    private OrganizationDto organization;

    public ApiResponseDto() {

    }

    public ApiResponseDto(EmployeeDto employee, DepartmentDto department, OrganizationDto organization) {
        this.employee = employee;
        this.department = department;
        this.organization = organization;
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

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }
}
