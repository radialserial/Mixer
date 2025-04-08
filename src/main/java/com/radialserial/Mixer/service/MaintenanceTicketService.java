package com.radialserial.Mixer.service;

import com.radialserial.Mixer.domain.model.MaintenanceTicket;

public interface MaintenanceTicketService {

    MaintenanceTicket findById(Long id);

    MaintenanceTicket create(MaintenanceTicket maintenanceTicket);
}
