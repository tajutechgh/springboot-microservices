package com.tajutechgh.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Details")
public class EmployeeDto {

    private Long id;

    @Schema(description = "Employee First Name")
    private String firstName;

    @Schema(description = "Employee Last Name")
    private String lastName;

    @Schema(description = "Employee Email")
    private String email;

    @Schema(description = "Employee Department Code")
    private String departmentCode;

    @Schema(description = "Employee Organization Code")
    private String organizationCode;

    public EmployeeDto(Long id, String firstName, String lastName, String email, String departmentCode, String organizationCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentCode = departmentCode;
        this.organizationCode = organizationCode;
    }

    public EmployeeDto() {

    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }
}