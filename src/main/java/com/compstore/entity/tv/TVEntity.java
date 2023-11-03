package com.compstore.entity.tv;

import com.compstore.entity.enums.Color;
import com.compstore.entity.enums.TVRefreshRate;
import com.compstore.entity.enums.TVResolutionName;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tvs")
@NoArgsConstructor
@AllArgsConstructor
public class TVEntity {

    @Id @GeneratedValue private UUID id;

    @ManyToOne
    @JoinColumn(name = "tv_brand_uuid")
    private TVBrandEntity tvBrand;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Color color;

    private Integer screenSize;

    @Enumerated(value = EnumType.STRING)
    private TVResolutionName resolutionName;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    @ManyToOne
    @JoinColumn(name = "screen_type_uuid")
    private TVScreenTypeEntity screenType;

    private boolean hdrFlag;

    @Enumerated(value = EnumType.STRING)
    private TVRefreshRate refreshRate;

    @Column(name = "smart_tv_flag")
    private boolean smartTVFlag;

    private boolean wifiFlag;

    private boolean bluetoothFlag;

    private Integer hdmiCount;

    private Integer usbCount;

    private BigDecimal price;
}
