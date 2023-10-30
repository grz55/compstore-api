package com.compstore.entity.smartphone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "smartphone_brands")
@NoArgsConstructor
@AllArgsConstructor
public class SmartphoneBrandEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}
