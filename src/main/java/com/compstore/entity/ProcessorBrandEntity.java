package com.compstore.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "processor_brands")
@NoArgsConstructor
@AllArgsConstructor
public class ProcessorBrandEntity {

    @Id @GeneratedValue private UUID id;

    private String name;

    @Column(name = "processor_brand_device_type")
    @Enumerated(value = EnumType.STRING)
    private ProcessorBrandDeviceType processorBrandDeviceType;
}
