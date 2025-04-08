package com.radialserial.Mixer.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @Column(nullable = false)
    private String fullName;

    private LocalDate birthDate;

    private String address;

    @Column(nullable = false)
    private String phone;
}
