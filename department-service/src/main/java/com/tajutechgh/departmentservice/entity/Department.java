package com.tajutechgh.departmentservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "department_description", nullable = false)
    private String departmentDescription;

    @Column(name = "department_code", nullable = false)
    private String departmentCode;

    public Department(Long id, String departmentName, String departmentDescription, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.departmentCode = departmentCode;
    }

    public Department() {
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