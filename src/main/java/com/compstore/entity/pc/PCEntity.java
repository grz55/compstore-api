package com.compstore.entity.pc;

import com.compstore.entity.ProductEntity;
import com.compstore.entity.dictionary.GraphicsCardBrandEntity;
import com.compstore.entity.dictionary.ProcessorBrandEntity;
import com.compstore.entity.pc.enums.DriveCapacity;
import com.compstore.entity.pc.enums.DriveType;
import com.compstore.entity.pc.enums.RAMCapacity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "pcs")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "pc_uuid")
public class PCEntity extends ProductEntity {

    @ManyToOne
    @JoinColumn(name = "processor_brand_uuid")
    private ProcessorBrandEntity processorBrand;

    private String processorName;

    @ManyToOne
    @JoinColumn(name = "graphics_card_brand_uuid")
    private GraphicsCardBrandEntity graphicsCardBrand;

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
}
