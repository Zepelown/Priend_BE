package com.server.priend.censor.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CensorUpdateRequest {
    private Long postId;
    private BigDecimal plantSoilMoisture;
    private BigDecimal plantTemperature;
}
