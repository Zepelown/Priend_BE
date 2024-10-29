package com.server.priend.censor.entity;

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
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    User user;
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
    @Column(precision = 6, scale = 3)
    private BigDecimal plantSoilMoisture;
    @Column(precision = 6, scale = 3)
    private BigDecimal plantTemperature;
}
