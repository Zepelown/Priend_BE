package com.server.priend.censor.payload.response;

import com.server.priend.censor.payload.dto.CensorData;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CensorDataResponse {
    private CensorData censorData;
}
