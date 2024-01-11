package com.compstore.entity.tv;

import com.compstore.entity.BrandEntity;
import com.compstore.entity.enums.Color;
import com.compstore.entity.tv.enums.RefreshRate;
import com.compstore.entity.tv.enums.ResolutionName;
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
    @JoinColumn(name = "brand_uuid")
    private BrandEntity brand;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Color color;

    private Integer screenSize;

    @Enumerated(value = EnumType.STRING)
    private ResolutionName resolutionName;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    @ManyToOne
    @JoinColumn(name = "screen_type_uuid")
    private TVScreenTypeEntity screenType;

    private boolean hdrFlag;

    @Enumerated(value = EnumType.STRING)
    private RefreshRate refreshRate;

    @Column(name = "smart_tv_flag")
    private boolean smartTVFlag;

    private boolean wifiFlag;

    private boolean bluetoothFlag;

    private Integer hdmiCount;

    private Integer usbCount;

    private BigDecimal price;
}
