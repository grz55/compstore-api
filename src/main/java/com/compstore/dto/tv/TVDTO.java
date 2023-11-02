package com.compstore.dto.tv;

import java.util.UUID;
import lombok.Data;

@Data
public class TVDTO {

    private UUID id;

    private String tvBrand;

    private String name;

    private String color;

    private Integer screenSize;

    private String resolutionName;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    private String screenType;

    private boolean hdrFlag;

    private Integer refreshRate;

    private boolean smartTVFlag;

    private boolean wifiFlag;

    private boolean bluetoothFlag;

    private Integer hdmiCount;

    private Integer usbCount;

    private Double price;
}
