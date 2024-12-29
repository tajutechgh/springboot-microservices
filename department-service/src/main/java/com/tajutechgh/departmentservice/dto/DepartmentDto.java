package com.tajutechgh.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    name = "DepartmentDto",
    description = "DepartmentDto Model Information"
)
public class DepartmentDto {

    private Long id;

    @Schema(description = "Department Name")
    private String departmentName;

    @Schema(description = "Department Description")
    private String departmentDescription;

    @Schema(description = "Department Code")
    private String departmentCode;

    public DepartmentDto(Long id, String departmentName, String departmentDescription, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.departmentCode = departmentCode;
    }

    public DepartmentDto() {
    }

    public Long getId() {
        return this.id;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getDepartmentDescription() {
        return this.departmentDescription;
    }

    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
