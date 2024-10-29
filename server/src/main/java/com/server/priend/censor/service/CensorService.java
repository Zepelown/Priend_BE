package com.server.priend.censor.service;

import com.server.priend.censor.entity.Pot;
import com.server.priend.censor.payload.dto.CensorData;
import com.server.priend.censor.payload.response.CensorDataResponse;
import com.server.priend.censor.repository.PotRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CensorService {
    private final PotRepository potRepository;

    @Autowired
    public CensorService(PotRepository potRepository) {
        this.potRepository = potRepository;
    }

    public CensorDataResponse requestPotData(Long potId) {
        CensorData censorData = potRepository.findCensorDataById(potId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid potId"));
        return new CensorDataResponse(censorData);
    }

    public void updatePotData(Long postId, BigDecimal soilMoisture, BigDecimal temperature) {
        Optional<Pot> potOptional = potRepository.findById(postId);

        if (potOptional.isPresent()) {
            Pot pot = potOptional.get();
            pot.setPlantSoilMoisture(soilMoisture);
            pot.setPlantTemperature(temperature);
            potRepository.save(pot); // 변경된 엔티티를 저장
        } else {
            // 예외 처리: 해당 postId로 Pot을 찾을 수 없음
            throw new EntityNotFoundException("Pot not found with id: " + postId);
        }
    }
}
