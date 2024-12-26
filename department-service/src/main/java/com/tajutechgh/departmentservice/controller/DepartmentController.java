package com.tajutechgh.departmentservice.controller;

import com.tajutechgh.departmentservice.dto.DepartmentDto;
import com.tajutechgh.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // TODO: Create Department
    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {

        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // TODO: Get Department
    @GetMapping("/get/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("departmentCode") String departmentCode) {

        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);

        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    // TODO: Get All Departments
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {

        List<DepartmentDto> departments = departmentService.getAllDepartments();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // TODO: Update Department
    @PutMapping("/update/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody DepartmentDto departmentDto) {

        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentId, departmentDto);

        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    // TODO: Delete Department
    @DeleteMapping("/delete/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") Long departmentId) {

        departmentService.deleteDepartment(departmentId);

        return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
    }
}