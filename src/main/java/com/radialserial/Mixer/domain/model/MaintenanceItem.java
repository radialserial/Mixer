package com.radialserial.Mixer.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@MappedSuperclass
@Getter
@Setter
abstract class MaintenanceItem {
    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Schema(description = "The description of the maintenance item.", example = "Axial bearing (replacement)")
    private String description;

    @Schema(description = "The cost of the maintenance item.", example = "50.00")
    @Column(precision = 13, scale = 2)
    private BigDecimal cost;
}
