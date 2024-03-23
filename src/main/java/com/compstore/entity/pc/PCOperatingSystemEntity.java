package com.compstore.entity.pc;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pc_operating_systems")
@NoArgsConstructor
@AllArgsConstructor
public class PCOperatingSystemEntity {

    @Id @GeneratedValue private UUID id;

    @Column(nullable = false)
    private String name;
}
