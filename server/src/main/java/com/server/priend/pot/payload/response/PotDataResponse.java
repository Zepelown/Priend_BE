package com.server.priend.pot.payload.response;

import com.server.priend.pot.payload.dto.PotData;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PotDataResponse {
    private PotData potData;
}
