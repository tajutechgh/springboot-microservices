package com.tajutechgh.organizationservice.service.implementation;

import com.tajutechgh.organizationservice.dto.OrganizationDto;
import com.tajutechgh.organizationservice.entity.Organization;
import com.tajutechgh.organizationservice.exception.ResourceNotFoundException;
import com.tajutechgh.organizationservice.mapper.OrganizationMapper;
import com.tajutechgh.organizationservice.repository.OrganizationRepository;
import com.tajutechgh.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImplementation implements OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationServiceImplementation(OrganizationRepository organizationRepository) {

        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        if (organization == null) {

            throw new ResourceNotFoundException("Organization", "organizationCode", organizationCode);
        }

        return OrganizationMapper.mapToOrganizationDto(organization);
    }

    @Override
    public List<OrganizationDto> getAllOrganizations() {

        List<Organization> organizations = organizationRepository.findAll();

        return organizations.stream().map(organization -> OrganizationMapper.mapToOrganizationDto(organization)).toList();
    }

    @Override
    public OrganizationDto updateOrganization(Long organizationId, OrganizationDto organizationDto) {

        Organization organization = organizationRepository.findById(organizationId).get();

        if (organization == null) {

            throw new ResourceNotFoundException("Organization", "organizationId", organizationId);
        }

        organization.setOrganizationName(organizationDto.getOrganizationName());
        organization.setOrganizationDescription(organizationDto.getOrganizationDescription());
        organization.setOrganizationCode(organizationDto.getOrganizationCode());

        Organization updatedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(updatedOrganization);
    }

    @Override
    public OrganizationDto deleteOrganization(Long organizationId) {

        Organization organization = organizationRepository.findById(organizationId).get();

        if (organization == null) {

            throw new ResourceNotFoundException("Organization", "organizationId", organizationId);
        }

        organizationRepository.delete(organization);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
