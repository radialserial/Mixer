package com.radialserial.Mixer.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentId;

    @Column(nullable = false)
    private String type;

    @Column(unique = true)
    private String serialCode;

    @ManyToOne
    private Owner owner;
}
