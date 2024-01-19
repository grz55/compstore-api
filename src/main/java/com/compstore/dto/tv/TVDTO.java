package com.compstore.dto.tv;

import com.compstore.dto.dictionary.BrandDTO;
import com.compstore.dto.dictionary.ScreenTypeDTO;
import java.util.UUID;
import lombok.Data;

@Data
public class TVDTO {

    private UUID id;

    private BrandDTO brand;

    private String name;

    private String color;

    private Integer screenSize;

    private String resolutionName;

    private Integer resolutionHeight;

    private Integer resolutionWidth;

    private ScreenTypeDTO screenType;

    private boolean hdrFlag;

    private Integer refreshRate;

    private boolean smartTVFlag;

    private boolean wifiFlag;

    private boolean bluetoothFlag;

    private Integer hdmiCount;

    private Integer usbCount;

    private Double price;
}
