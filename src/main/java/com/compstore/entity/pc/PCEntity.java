package com.compstore.entity.pc;

import com.compstore.entity.ProductEntity;
import com.compstore.entity.enums.PCDriveType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pcs")
@NoArgsConstructor
@AllArgsConstructor
public class PCEntity extends ProductEntity {

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private PCProcessorBrandEntity processorBrand;

    private String processorName;

    @ManyToOne
    private PCGraphicsCardBrandEntity graphicsCardBrand;

    private String graphicsCardName;

    @Column(name = "ram_gb_capacity")
    private Integer ramGBCapacity;

    @Column(name = "drive_gb_capacity")
    private Integer driveGBCapacity;

    private PCDriveType driveType;

    @ManyToOne
    private PCOperatingSystemEntity operatingSystem;

}
