package com.tajutechgh.departmentservice.service.implementation;

import com.tajutechgh.departmentservice.dto.DepartmentDto;
import com.tajutechgh.departmentservice.entity.Department;
import com.tajutechgh.departmentservice.exception.ResourceNotFoundException;
import com.tajutechgh.departmentservice.mapper.DepartmentMapper;
import com.tajutechgh.departmentservice.repository.DepartmentRepository;
import com.tajutechgh.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImplementation(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        if (department == null) {

            throw new ResourceNotFoundException("Department", "departmentCode", departmentCode);
        }

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(department -> DepartmentMapper.mapToDepartmentDto(department)).toList();
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto departmentDto) {

        Department department = departmentRepository.findById(departmentId).get();

        if (department == null) {
            throw new ResourceNotFoundException("Department", "departmentId", departmentId);
        }

        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentCode(departmentDto.getDepartmentCode());

        Department updateDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updateDepartment);
    }

    @Override
    public DepartmentDto deleteDepartment(Long departmentId) {

        Department department = departmentRepository.findById(departmentId).get();

        if (department == null) {
            throw new ResourceNotFoundException("Department", "departmentId", departmentId);
        }

        departmentRepository.delete(department);

        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
