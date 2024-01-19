package com.compstore.entity.dictionary;

import com.compstore.entity.dictionary.enums.ProcessorBrandDeviceType;
import com.compstore.entity.pc.PCEntity;
import com.compstore.entity.smartphone.SmartphoneEntity;
import jakarta.persistence.*;
import java.util.*;
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

    @OneToMany(mappedBy = "processorBrand")
    private List<PCEntity> pcs = new ArrayList<>();

    @OneToMany(mappedBy = "processorBrand")
    private List<SmartphoneEntity> smartphones = new ArrayList<>();

    public boolean isUsed() {
        return !pcs.isEmpty() || !smartphones.isEmpty();
    }

    public String getEntityName() {
        return "Processor brand";
    }
}
