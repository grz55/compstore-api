package com.compstore.dto.tv;

import lombok.Data;

@Data
public class TVCreateRequestDTO {

    private String brand;

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
