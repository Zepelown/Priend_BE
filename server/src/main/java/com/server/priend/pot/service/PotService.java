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
        Pot pot = potRepository.findById(potId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid potId"));
        return new PotDataResponse(PotData.of(pot));
    }

    public void updatePotData(Long postId, BigDecimal soilMoisture, BigDecimal temperature) {
        Optional<Pot> potOptional = potRepository.findById(postId);

        if (potOptional.isPresent()) {
            Pot pot = potOptional.get();
            pot.setPlantSoilMoisture(soilMoisture);
            pot.setPlantTemperature(temperature);
            potRepository.save(pot);
        } else {
            throw new EntityNotFoundException("Pot not found with id: " + postId);
        }
    }
}
