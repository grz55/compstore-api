package com.compstore.entity.smartphone;

import com.compstore.entity.enums.Color;
import com.compstore.entity.smartphone.enums.RAMCapacity;
import com.compstore.entity.smartphone.enums.StorageCapacity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "smartphones")
@NoArgsConstructor
@AllArgsConstructor
public class SmartphoneEntity {

    @Id @GeneratedValue private UUID id;

    @ManyToOne
    @JoinColumn(name = "smartphone_brand_uuid")
    private SmartphoneBrandEntity smartphoneBrand;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Color color;

    private Double screenSize;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    @ManyToOne
    @JoinColumn(name = "smartphone_screen_type_uuid")
    private SmartphoneScreenTypeEntity smartphoneScreenType;

    private Integer batteryCapacity;

    @Column(name = "ram_capacity")
    @Enumerated(value = EnumType.STRING)
    private RAMCapacity ramCapacity;

    @Column(name = "storage_capacity")
    @Enumerated(value = EnumType.STRING)
    private StorageCapacity storageCapacity;

    private Integer frontCameraMpixResolution;

    private Integer backCameraMpixResolution;

    @ManyToOne
    @JoinColumn(name = "operating_system_uuid")
    private SmartphoneOperatingSystemEntity operatingSystem;

    @ManyToOne
    @JoinColumn(name = "processor_brand_uuid")
    private SmartphoneProcessorBrandEntity processorBrand;

    private String processorName;

    private BigDecimal price;
}
