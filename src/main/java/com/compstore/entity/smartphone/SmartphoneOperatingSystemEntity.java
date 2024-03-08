package com.compstore.entity.smartphone;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "smartphone_operating_systems")
@NoArgsConstructor
@AllArgsConstructor
public class SmartphoneOperatingSystemEntity {

    @Id @GeneratedValue private UUID id;

    @Column(nullable = false)
    private String name;
}
