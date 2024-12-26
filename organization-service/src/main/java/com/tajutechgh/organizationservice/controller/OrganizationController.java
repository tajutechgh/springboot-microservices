package com.tajutechgh.organizationservice.controller;

import com.tajutechgh.organizationservice.dto.OrganizationDto;
import com.tajutechgh.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {

        this.organizationService = organizationService;
    }

    // TODO: Create Organization
    @PostMapping("/create")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){

        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    // TODO: Get Organization By Code
    @GetMapping("get/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("organizationCode") String organizationCode){

        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);

        return ResponseEntity.ok(organizationDto);
    }

    // TODO: Get All Organizations
    @GetMapping("/all")
    public ResponseEntity<List<OrganizationDto>> getAllOrganizations() {

        List<OrganizationDto> organizations = organizationService.getAllOrganizations();

        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    // TODO: Update Organization
    @PutMapping("/update/{organizationId}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable("organizationId") Long organizationId, @RequestBody OrganizationDto organizationDto) {

        OrganizationDto updatedOrganization = organizationService.updateOrganization(organizationId, organizationDto);

        return new ResponseEntity<>(updatedOrganization, HttpStatus.OK);
    }

    // TODO: Delete Organization
    @DeleteMapping("/delete/{organizationId}")
    public ResponseEntity<String> deleteOrganization(@PathVariable("organizationId") Long organizationId) {

        organizationService.deleteOrganization(organizationId);

        return new ResponseEntity<>("Organization deleted successfully", HttpStatus.OK);
    }
}