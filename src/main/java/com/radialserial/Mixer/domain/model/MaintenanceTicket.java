package com.radialserial.Mixer.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class MaintenanceTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @OneToMany
    private List<Repair> repairs;

    @OneToMany
    private List<Part> parts;

    @OneToOne
    private Equipment equipment;
}
