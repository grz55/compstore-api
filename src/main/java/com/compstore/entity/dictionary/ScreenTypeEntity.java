package com.compstore.entity.dictionary;

import com.compstore.entity.dictionary.enums.ScreenTypeDeviceType;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "screen_types")
@NoArgsConstructor
@AllArgsConstructor
public class ScreenTypeEntity {

    @Id @GeneratedValue private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "screen_type_device_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ScreenTypeDeviceType screenTypeDeviceType;
}
