package com.tajutechgh.employeeservice.controller;

import com.tajutechgh.employeeservice.dto.ApiResponseDto;
import com.tajutechgh.employeeservice.dto.EmployeeDto;
import com.tajutechgh.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Employee Service Controller",
        description = "Employee Service Controller for Rest APIs"
)
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    // TODO: Create Employee
    @Operation(
            summary = "Create New Employee",
            description = "Create New Employee"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // TODO: Get Employee
    @Operation(
            summary = "Get Employee By Id",
            description = "Get Employee By Id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("employeeId") Long employeeId) {

        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);

        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    // TODO: Get All Employees
    @Operation(
            summary = "Get All Employees",
            description = "Get All Employees"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

        List<EmployeeDto> employees = employeeService.getAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // TODO: Update Employee
    @Operation(
            summary = "Update Employee",
            description = "Update Employee"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @PutMapping("/update/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody EmployeeDto employeeDto) {

        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId, employeeDto);

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // TODO: Delete Employee
    @Operation(
            summary = "Delete Employee",
            description = "Delete Employee"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId) {

        employeeService.deleteEmployee(employeeId);

        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}