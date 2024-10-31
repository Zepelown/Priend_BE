package com.server.priend.pot.service;

import com.server.priend.pot.entity.Pot;
import com.server.priend.pot.payload.dto.PotData;
import com.server.priend.pot.payload.response.PotDataResponse;
import com.server.priend.pot.repository.PotRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PotService {
    private final PotRepository potRepository;

    @Autowired
    public PotService(PotRepository potRepository) {
        this.potRepository = potRepository;
    }

    public PotDataResponse requestPotData(Long potId) {
        PotData potData = potRepository.findCensorDataById(potId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid potId"));
        return new PotDataResponse(potData);
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
