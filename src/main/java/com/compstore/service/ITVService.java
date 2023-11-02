package com.compstore.service;

import com.compstore.dto.tv.TVDTO;
import java.util.UUID;

public interface ITVService {

    TVDTO getTVById(UUID tvId);
}
