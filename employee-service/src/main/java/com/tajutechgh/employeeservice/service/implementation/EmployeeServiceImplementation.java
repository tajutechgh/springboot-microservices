package com.tajutechgh.employeeservice.service.implementation;

import com.tajutechgh.employeeservice.dto.EmployeeDto;
import com.tajutechgh.employeeservice.entity.Employee;
import com.tajutechgh.employeeservice.exception.ResourceNotFoundException;
import com.tajutechgh.employeeservice.mapper.EmployeeMapper;
import com.tajutechgh.employeeservice.repository.EmployeeRepository;
import com.tajutechgh.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(

            () -> new ResourceNotFoundException("Employee", "employeeId", employeeId)
        );

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee)).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(

            () -> new ResourceNotFoundException("Employee", "employeeId", employeeId)
        );

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public EmployeeDto deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "employeeId", employeeId)
        );

        employeeRepository.delete(employee);

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}