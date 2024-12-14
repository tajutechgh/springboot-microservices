package com.tajutechgh.employeeservice.service.implementation;

import com.tajutechgh.employeeservice.dto.ApiResponseDto;
import com.tajutechgh.employeeservice.dto.DepartmentDto;
import com.tajutechgh.employeeservice.dto.EmployeeDto;
import com.tajutechgh.employeeservice.entity.Employee;
import com.tajutechgh.employeeservice.exception.ResourceNotFoundException;
import com.tajutechgh.employeeservice.mapper.EmployeeMapper;
import com.tajutechgh.employeeservice.repository.EmployeeRepository;
import com.tajutechgh.employeeservice.service.ApiClient;
import com.tajutechgh.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private static final String DEPARTMENT_SERVICE_URL = "http://localhost:8080/api/departments/get/";

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

//    private WebClient webClient;

    private ApiClient apiClient;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository, ApiClient apiClient) {

        this.employeeRepository = employeeRepository;

//        this.restTemplate = restTemplate;

//        this.webClient = webClient;

        this.apiClient = apiClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

        if (employee == null) {
            throw new ResourceNotFoundException("Employee", "employeeId", employeeId);
        }

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(DEPARTMENT_SERVICE_URL + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri(DEPARTMENT_SERVICE_URL + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto = new ApiResponseDto(employeeDto, departmentDto);

        return apiResponseDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee)).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(employeeId).get();

        if (employee == null) {
            throw new ResourceNotFoundException("Employee", "employeeId", employeeId);
        }

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public EmployeeDto deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

        if (employee == null) {
            throw new ResourceNotFoundException("Employee", "employeeId", employeeId);
        }

        employeeRepository.delete(employee);

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}