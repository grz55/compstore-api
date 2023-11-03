package com.compstore.entity.pc;

import com.compstore.entity.enums.PCDriveType;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pcs")
@NoArgsConstructor
@AllArgsConstructor
public class PCEntity {

    @Id @GeneratedValue private UUID id;

    @ManyToOne
    @JoinColumn(name = "processor_brand_uuid")
    private PCProcessorBrandEntity processorBrand;

    private String processorName;

    @ManyToOne
    @JoinColumn(name = "graphics_card_brand_uuid")
    private PCGraphicsCardBrandEntity graphicsCardBrand;

    private String graphicsCardName;

    @Column(name = "ram_gb_capacity")
    private Integer ramGBCapacity;

    @Column(name = "drive_gb_capacity")
    private Integer driveGBCapacity;

    @Enumerated(value = EnumType.STRING)
    private PCDriveType driveType;

    @ManyToOne
    @JoinColumn(name = "operating_system_uuid")
    private PCOperatingSystemEntity operatingSystem;

    private BigDecimal price;
}
