package com.compstore.entity.dictionary;

import com.compstore.entity.dictionary.enums.GraphicsCardBrandDeviceType;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "graphics_card_brands")
@NoArgsConstructor
@AllArgsConstructor
public class GraphicsCardBrandEntity {

    @Id @GeneratedValue private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "graphics_card_brand_device_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GraphicsCardBrandDeviceType graphicsCardBrandDeviceType;
}
