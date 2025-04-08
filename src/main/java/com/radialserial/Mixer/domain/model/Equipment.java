package com.radialserial.Mixer.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Equipment {
    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;

    @Schema(description = "The type of equipment.", example = "Cement mixer")
    @Column(nullable = false)
    private String type;

    @Schema(description = "The serial identification code for the equipment.", example = "CM001")
    @Column(unique = true)
    private String serialCode;

    @Schema(description = "The equipment's owner.")
    @ManyToOne(cascade = CascadeType.ALL)
    private Owner owner;
}
