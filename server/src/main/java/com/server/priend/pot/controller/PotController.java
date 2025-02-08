package com.server.priend.pot.controller;

import com.server.priend.common.payload.response.Response;
import com.server.priend.pot.payload.request.PotDataRequest;
import com.server.priend.pot.payload.request.PotUpdateRequest;
import com.server.priend.pot.payload.response.PotDataResponse;
import com.server.priend.pot.service.PotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant/censor/")
public class PotController {
    private static final Logger logger = LoggerFactory.getLogger(PotController.class);
    private final PotService potService;

    @Autowired
    public PotController(PotService potService) {
        this.potService = potService;
    }

    @PostMapping("data")
    public ResponseEntity<Response> getCensorData(@RequestBody PotDataRequest potDataRequest) {
        PotDataResponse censorData = potService.requestPotData(potDataRequest.getPotId());
        logger.info(censorData.getPotData().getPlantName());
        Response response = Response.ok("수신성공", censorData);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<Response> updateCensorData(@RequestBody PotUpdateRequest potUpdateRequest) {
        potService.updatePotData(potUpdateRequest);
        Response response = Response.builder()
                .message("수신 성공")
                .build();
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
