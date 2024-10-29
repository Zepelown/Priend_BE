package com.server.priend.censor.controller;

import com.server.priend.censor.payload.dto.CensorData;
import com.server.priend.censor.payload.request.CensorDataRequest;
import com.server.priend.censor.service.CensorService;
import com.server.priend.common.payload.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant/censor/")
public class CensorController {
    private final CensorService censorService;

    @Autowired
    public CensorController(CensorService censorService) {
        this.censorService = censorService;
    }

    @PostMapping("data")
    public ResponseEntity<Response> getCensorData(@RequestBody CensorDataRequest censorDataRequest) {
        CensorData censorData = censorService.requestPotData(censorDataRequest.getPotId());
        Response response = Response.builder()
                .message("수신 성공")
                .data(censorData)
                .build();
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
