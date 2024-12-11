package com.tajutechgh.employeeservice.controller;

import com.tajutechgh.employeeservice.dto.EmployeeDto;
import com.tajutechgh.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    // TODO: Create Employee
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {

        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // TODO: Get Employee
    @GetMapping("/get/{employee-id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employee-id") Long employeeId) {

        EmployeeDto employee = employeeService.getEmployeeById(employeeId);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // TODO: Get All Employees
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

        List<EmployeeDto> employees = employeeService.getAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // TODO: Update Employee
    @PutMapping("/update/{employee-id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("employee-id") Long employeeId, @RequestBody EmployeeDto employeeDto) {

        EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId, employeeDto);

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // TODO: Delete Employee
    @DeleteMapping("/delete/{employee-id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employee-id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);

        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}