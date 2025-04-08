package com.radialserial.Mixer.service.impl;

import com.radialserial.Mixer.domain.model.MaintenanceTicket;
import com.radialserial.Mixer.domain.model.MaintenanceTicketRepository;
import com.radialserial.Mixer.service.MaintenanceTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MaintenanceTicketServiceImpl implements MaintenanceTicketService {

    private final MaintenanceTicketRepository maintenanceTicketRepository;

    @Autowired
    public MaintenanceTicketServiceImpl(MaintenanceTicketRepository maintenanceTicketRepository) {
        this.maintenanceTicketRepository = maintenanceTicketRepository;
    }

    @Override
    public MaintenanceTicket findById(Long id) {
        return this.maintenanceTicketRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public MaintenanceTicket create(MaintenanceTicket maintenanceTicket) {
        return this.maintenanceTicketRepository.save(maintenanceTicket);
    }
}
