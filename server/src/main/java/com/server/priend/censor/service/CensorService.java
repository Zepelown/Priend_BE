package com.server.priend.censor.service;

import com.server.priend.censor.payload.dto.CensorData;
import com.server.priend.censor.repository.PotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CensorService {
    private final PotRepository potRepository;

    @Autowired
    public CensorService(PotRepository potRepository) {
        this.potRepository = potRepository;
    }

    public CensorData requestPotData(Long potId) {
        return potRepository.findCensorDataById(potId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid potId"));
    }
}
