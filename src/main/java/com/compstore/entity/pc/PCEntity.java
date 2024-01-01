package com.compstore.entity.pc;

import com.compstore.entity.pc.enums.DriveCapacity;
import com.compstore.entity.pc.enums.DriveType;
import com.compstore.entity.pc.enums.RAMCapacity;
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

    @Column(name = "ram_capacity")
    @Enumerated(value = EnumType.STRING)
    private RAMCapacity ramCapacity;

    @Column(name = "drive_capacity")
    @Enumerated(value = EnumType.STRING)
    private DriveCapacity driveCapacity;

    @Enumerated(value = EnumType.STRING)
    private DriveType driveType;

    @ManyToOne
    @JoinColumn(name = "operating_system_uuid")
    private PCOperatingSystemEntity operatingSystem;

    private BigDecimal price;
}
