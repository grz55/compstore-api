package com.compstore.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
public class BrandEntity {

    @Id @GeneratedValue private UUID id;

    private String name;

    @Column(name = "brands_device_type")
    @Enumerated(value = EnumType.STRING)
    private BrandDeviceType brandDeviceType;
}
