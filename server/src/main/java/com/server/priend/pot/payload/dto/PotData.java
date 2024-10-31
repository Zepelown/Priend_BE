package com.server.priend.pot.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class PotData {
    private BigDecimal plantSoilMoisture;
    private BigDecimal plantTemperature;
}
