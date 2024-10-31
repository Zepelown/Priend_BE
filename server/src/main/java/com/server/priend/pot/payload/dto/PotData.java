package com.server.priend.pot.payload.dto;

import com.server.priend.pot.entity.Pot;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PotData {
    private String potType;
    private String plantName;
    private LocalDate plantStartDate;
    private Short plantAge;
    private BigDecimal plantSoilMoisture;
    private BigDecimal plantTemperature;

    public static PotData of(Pot pot){
        return new PotData(
                pot.getPotType(),
                pot.getPlantName(),
                pot.getPlantStartDate(),
                pot.getPlantAge(),
                pot.getPlantSoilMoisture(),
                pot.getPlantTemperature()
        );
    }
}
