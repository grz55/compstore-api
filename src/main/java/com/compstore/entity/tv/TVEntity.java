package com.compstore.entity.tv;

import com.compstore.entity.ProductEntity;
import com.compstore.entity.dictionary.BrandEntity;
import com.compstore.entity.dictionary.ScreenTypeEntity;
import com.compstore.entity.enums.Color;
import com.compstore.entity.tv.enums.RefreshRate;
import com.compstore.entity.tv.enums.ResolutionName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tvs")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "tv_uuid")
public class TVEntity extends ProductEntity {

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
    private ScreenTypeEntity screenType;

    private boolean hdrFlag;

    @Enumerated(value = EnumType.STRING)
    private RefreshRate refreshRate;

    @Column(name = "smart_tv_flag")
    private boolean smartTVFlag;

    private boolean wifiFlag;

    private boolean bluetoothFlag;

    private Integer hdmiCount;

    private Integer usbCount;
}
