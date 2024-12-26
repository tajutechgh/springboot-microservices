package com.tajutechgh.organizationservice.service;

import com.tajutechgh.organizationservice.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String organizationCode);

    List<OrganizationDto> getAllOrganizations();

    OrganizationDto updateOrganization(Long organizationId, OrganizationDto organizationDto);

    OrganizationDto deleteOrganization(Long organizationId);
}