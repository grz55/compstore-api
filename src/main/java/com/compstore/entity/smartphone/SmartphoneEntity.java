package com.compstore.entity.smartphone;

import com.compstore.entity.enums.Color;
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

    @Column(name = "ram_gb_capacity")
    private Integer ramGBCapacity;

    @Column(name = "storage_gb_capacity")
    private Integer storageGBCapacity;

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
