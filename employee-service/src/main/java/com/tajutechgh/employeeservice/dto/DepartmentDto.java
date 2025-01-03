package com.tajutechgh.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Department Details")
public class DepartmentDto {

    Long id;

    @Schema(description = "Department Name")
    String departmentName;

    @Schema(description = "Department Description")
    String departmentDescription;

    @Schema(description = "Department Code")
    String departmentCode;

    public DepartmentDto() {

    }

    public DepartmentDto(Long id, String departmentName, String departmentDescription, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.departmentCode = departmentCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}