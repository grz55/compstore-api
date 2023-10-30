package com.compstore.entity.pc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pc_processor_brands")
@NoArgsConstructor
@AllArgsConstructor
public class PCProcessorBrandEntity {

    @Id @GeneratedValue private UUID id;

    private String name;
}
