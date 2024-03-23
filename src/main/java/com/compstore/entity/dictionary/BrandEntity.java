package com.compstore.entity.dictionary;

import com.compstore.entity.dictionary.enums.BrandDeviceType;
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

    @Column(nullable = false)
    private String name;

    @Column(name = "brands_device_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BrandDeviceType brandDeviceType;
}
