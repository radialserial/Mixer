package com.radialserial.Mixer.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Owner {
    @Schema(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @Schema(description = "The owner's full name.", example = "John N. Doe")
    @Column(nullable = false)
    private String fullName;

    @Schema(description = "The owner's full address.", example = "22 acacia ave.")
    private String address;

    @Schema(description = "The owner's phone number.", example = "5550-1234")
    @Column(nullable = false)
    private String phone;
}
