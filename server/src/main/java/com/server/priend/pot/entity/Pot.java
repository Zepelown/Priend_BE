package com.server.priend.pot.entity;

import com.server.priend.auth.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pot {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pot_id")
    private Long potId;
    @NotNull
    private String potType;
    @NotNull
    private String plantName;
    @NotNull
    private LocalDate plantStartDate;
    private Short plantAge;
    @Column(precision = 6, scale = 1)
    private BigDecimal plantSoilMoisture;
    @Column(precision = 6, scale = 1)
    private BigDecimal plantTemperature;
    @Column(precision = 6, scale = 1)
    private BigDecimal plantHumidity;
    @Column(precision = 6, scale = 1)
    private BigDecimal plantIlluminance;
}
