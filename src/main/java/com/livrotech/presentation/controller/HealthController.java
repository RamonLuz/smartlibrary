package com.livrotech.presentation.controller;

import com.livrotech.presentation.response.HealthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public HealthResponse health() {

        return new HealthResponse(
                "UP",
                "livrotech"
        );
    }
}