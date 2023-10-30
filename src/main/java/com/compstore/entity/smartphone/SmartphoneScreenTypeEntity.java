package com.compstore.entity.smartphone;

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
@Table(name = "smartphone_screen_types")
@NoArgsConstructor
@AllArgsConstructor
public class SmartphoneScreenTypeEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}
