package com.radialserial.Mixer.controller;

import com.radialserial.Mixer.domain.model.MaintenanceTicket;
import com.radialserial.Mixer.service.MaintenanceTicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;

@Slf4j
@Tag(name = "Maintenance ticket controller", description = "Management for maintenance tickets for heavy equipment.")
@RestController
@RequestMapping("/ticket")
public class MaintenanceTicketController {

    private final MaintenanceTicketService maintenanceTicketService;

    @Autowired
    public MaintenanceTicketController(MaintenanceTicketService maintenanceTicketService) {
        this.maintenanceTicketService = maintenanceTicketService;
    }

    @Operation(
            summary = "Finds a maintenance ticket by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ticket located."),
                    @ApiResponse(responseCode = "404", description = "Ticket not found."),
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceTicket> findById(
            @Parameter(description = "The id of the ticket to be located.", example = "0")
            @PathVariable
            Long id
    ) {
        MaintenanceTicket maintenanceTicket = null;

        try {
            maintenanceTicket = maintenanceTicketService.findById(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(maintenanceTicket);
    }

    @Operation(
            summary = "Creates a new ticket.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Ticket created successfully."),
                    @ApiResponse(responseCode = "400", description = "Malformed ticket data."),
                    @ApiResponse(responseCode = "500", description = "General exception."),
            }
    )
    @PostMapping
    public ResponseEntity<MaintenanceTicket> create(@RequestBody MaintenanceTicket maintenanceTicket) {
        MaintenanceTicket createdTicket = null;

        try {
            createdTicket = maintenanceTicketService.create(maintenanceTicket);
        } catch (HttpMessageNotReadableException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTicket.getTicketId())
                .toUri();
        return ResponseEntity.created(location).body(createdTicket);
    }

}