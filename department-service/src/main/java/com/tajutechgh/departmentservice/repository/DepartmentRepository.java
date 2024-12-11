package com.tajutechgh.departmentservice.repository;

import com.tajutechgh.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentCode(String departmentCode);
}