package com.server.priend.censor.repository;

import com.server.priend.censor.entity.Pot;
import com.server.priend.censor.payload.dto.CensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PotRepository extends JpaRepository<Pot,Long> {
    @Query("SELECT new  com.server.priend.censor.payload.dto.CensorData(p.plantSoilMoisture, p.plantTemperature)"+"FROM Pot p WHERE p.potId = :id")
    Optional<CensorData> findCensorDataById(Long id);
}
