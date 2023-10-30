package com.compstore.entity.tv;

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
@Table(name = "tv_brands")
@NoArgsConstructor
@AllArgsConstructor
public class TVScreenTypeEntity {

    @Id @GeneratedValue private UUID id;

    private String name;
}
