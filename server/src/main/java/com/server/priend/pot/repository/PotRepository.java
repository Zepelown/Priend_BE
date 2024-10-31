package com.server.priend.pot.repository;

import com.server.priend.pot.entity.Pot;
import com.server.priend.pot.payload.dto.PotData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PotRepository extends JpaRepository<Pot,Long> {
    @Query("SELECT new  com.server.priend.pot.payload.dto.CensorData(p.plantSoilMoisture, p.plantTemperature)"+"FROM Pot p WHERE p.potId = :id")
    Optional<PotData> findCensorDataById(Long id);
}
