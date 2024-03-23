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
    @JoinColumn(name = "brand_uuid", nullable = false)
    private BrandEntity brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Color color;

    @Column(nullable = false)
    private Integer screenSize;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ResolutionName resolutionName;

    @Column(nullable = false)
    private Integer resolutionHeight;

    @Column(nullable = false)
    private Integer resolutionWidth;

    @ManyToOne
    @JoinColumn(name = "screen_type_uuid", nullable = false)
    private ScreenTypeEntity screenType;

    @Column(nullable = false)
    private boolean hdrFlag;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RefreshRate refreshRate;

    @Column(name = "smart_tv_flag", nullable = false)
    private boolean smartTVFlag;

    @Column(nullable = false)
    private boolean wifiFlag;

    @Column(nullable = false)
    private boolean bluetoothFlag;

    @Column(nullable = false)
    private Integer hdmiCount;

    @Column(nullable = false)
    private Integer usbCount;
}
