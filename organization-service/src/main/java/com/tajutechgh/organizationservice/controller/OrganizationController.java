package com.tajutechgh.organizationservice.controller;

import com.tajutechgh.organizationservice.dto.OrganizationDto;
import com.tajutechgh.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Organization Service Controller",
        description = "Organization Service Controller for Rest APIs"
)
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {

        this.organizationService = organizationService;
    }

    // TODO: Create Organization
    @Operation(
            summary = "Create New Organization",
            description = "Create New Organization"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    @PostMapping("/create")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){

        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    // TODO: Get Organization By Code
    @Operation(
            summary = "Get Organization By Code",
            description = "Get Organization By Code"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("get/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("organizationCode") String organizationCode){

        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);

        return ResponseEntity.ok(organizationDto);
    }

    // TODO: Get All Organizations
    @Operation(
            summary = "Get All Organizations",
            description = "Get All Organizations"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/all")
    public ResponseEntity<List<OrganizationDto>> getAllOrganizations() {

        List<OrganizationDto> organizations = organizationService.getAllOrganizations();

        return new ResponseEntity<>(organizations, HttpStatus.OK);
    }

    // TODO: Update Organization
    @Operation(
            summary = "Update Organization",
            description = "Update Organization"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @PutMapping("/update/{organizationId}")
    public ResponseEntity<OrganizationDto> updateOrganization(@PathVariable("organizationId") Long organizationId, @RequestBody OrganizationDto organizationDto) {

        OrganizationDto updatedOrganization = organizationService.updateOrganization(organizationId, organizationDto);

        return new ResponseEntity<>(updatedOrganization, HttpStatus.OK);
    }

    // TODO: Delete Organization
    @Operation(
            summary = "Delete Organization",
            description = "Delete Organization"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @DeleteMapping("/delete/{organizationId}")
    public ResponseEntity<String> deleteOrganization(@PathVariable("organizationId") Long organizationId) {

        organizationService.deleteOrganization(organizationId);

        return new ResponseEntity<>("Organization deleted successfully", HttpStatus.OK);
    }
}