package com.server.priend.pot.payload.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PotUpdateRequest {
    private Long potId;
    private BigDecimal plantSoilMoisture;
    private BigDecimal plantTemperature;
    private BigDecimal plantHumidity;
    private BigDecimal plantIlluminance;
}
