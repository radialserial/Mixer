package com.radialserial.Mixer.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class MaintenanceTicket {
    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @Schema(description = "List of repairs made on the equipment.")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Repair> repairs;

    @Schema(description = "Parts used when repairing the equipment.")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Part> parts;

    @Schema(description = "The heavy equipment on which repairs are being done.")
    @OneToOne(cascade = CascadeType.ALL)
    private Equipment equipment;
}
