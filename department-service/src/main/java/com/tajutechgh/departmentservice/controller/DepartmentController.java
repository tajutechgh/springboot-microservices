package com.tajutechgh.departmentservice.controller;

import com.tajutechgh.departmentservice.dto.DepartmentDto;
import com.tajutechgh.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
    name = "Department Service Controller",
    description = "Department Service Controller for Rest APIs"
)
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // TODO: Create Department
    @Operation(
        summary = "Create New Department",
        description = "Create New Department"
    )
    @ApiResponse(
        responseCode = "201",
        description = "Created"
    )
    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {

        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // TODO: Get Department
    @Operation(
            summary = "Get Department By Code",
            description = "Get Department By Code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/get/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("departmentCode") String departmentCode) {

        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);

        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    // TODO: Get All Departments
    @Operation(
            summary = "Get All Departments",
            description = "Get All Departments"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {

        List<DepartmentDto> departments = departmentService.getAllDepartments();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // TODO: Update Department
    @Operation(
            summary = "Update Department",
            description = "Update Department"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @PutMapping("/update/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody DepartmentDto departmentDto) {

        DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentId, departmentDto);

        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    // TODO: Delete Department
    @Operation(
            summary = "Delete Department",
            description = "Delete Department"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @DeleteMapping("/delete/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") Long departmentId) {

        departmentService.deleteDepartment(departmentId);

        return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
    }
}