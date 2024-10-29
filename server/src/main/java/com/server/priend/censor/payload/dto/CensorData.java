package com.server.priend.censor.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class CensorData {
    private BigDecimal plantSoilMoisture;
    private BigDecimal plantTemperature;
}
