package org.thief.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.thief.service.StealService;

@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
public class ThiefController {

    private final StealService stealService;

    @PostMapping("/steal")
    @ResponseStatus(HttpStatus.OK)
    public void steal(@RequestBody SolRequest solRequest) {
        stealService.stealNasaData(solRequest.sol());
    }
}
