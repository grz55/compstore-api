package com.compstore.entity.tv;

import com.compstore.entity.enums.Color;
import com.compstore.entity.enums.TVRefreshRate;
import com.compstore.entity.enums.TVResolutionName;
import jakarta.persistence.*;

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
    private TVBrandEntity tvBrand;

    private Color color;

    private Integer screenSize;

    private TVResolutionName resolutionName;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    @ManyToOne
    private TVScreenTypeEntity screenType;

    private boolean hdrFlag;

    private TVRefreshRate refreshRate;

    @Column(name = "smart_tv_flag")
    private boolean smartTVFlag;

    private boolean wifiFlag;

    private boolean bluetoothFlag;

    private Integer hdmiCount;

    private Integer usbCount;

}
