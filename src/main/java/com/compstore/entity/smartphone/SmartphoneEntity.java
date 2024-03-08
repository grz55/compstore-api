package com.compstore.entity.smartphone;

import com.compstore.entity.ProductEntity;
import com.compstore.entity.dictionary.BrandEntity;
import com.compstore.entity.dictionary.ProcessorBrandEntity;
import com.compstore.entity.dictionary.ScreenTypeEntity;
import com.compstore.entity.enums.Color;
import com.compstore.entity.smartphone.enums.RAMCapacity;
import com.compstore.entity.smartphone.enums.StorageCapacity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "smartphones")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "smartphone_uuid")
public class SmartphoneEntity extends ProductEntity {

    @ManyToOne
    @JoinColumn(name = "brand_uuid", nullable = false)
    private BrandEntity brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Color color;

    @Column(nullable = false)
    private Double screenSize;

    @Column(nullable = false)
    private Integer resolutionHeight;

    @Column(nullable = false)
    private Integer resolutionWidth;

    @ManyToOne
    @JoinColumn(name = "screen_type_uuid", nullable = false)
    private ScreenTypeEntity screenType;

    private Integer batteryCapacity;

    @Column(name = "ram_capacity")
    @Enumerated(value = EnumType.STRING)
    private RAMCapacity ramCapacity;

    @Column(name = "storage_capacity", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private StorageCapacity storageCapacity;

    private Integer frontCameraMpixResolution;

    @Column(nullable = false)
    private Integer backCameraMpixResolution;

    @ManyToOne
    @JoinColumn(name = "operating_system_uuid", nullable = false)
    private SmartphoneOperatingSystemEntity operatingSystem;

    @ManyToOne
    @JoinColumn(name = "processor_brand_uuid", nullable = false)
    private ProcessorBrandEntity processorBrand;

    @Column(nullable = false)
    private String processorName;
}
