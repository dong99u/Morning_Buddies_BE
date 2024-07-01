package com.morningbuddies.morningbuddies.web.controller;

import com.morningbuddies.morningbuddies.apiPayload.ApiResponse;
import com.morningbuddies.morningbuddies.converter.HealthConverter;
import com.morningbuddies.morningbuddies.web.dto.health.HealthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/health")
    public ApiResponse<HealthResponse.HealthResponseDTO> healthCheck() {

        String message = "MorningBuddies is running";

        HealthResponse.HealthResponseDTO healthResponseDTO = HealthConverter.toHealthResponseDTO(message);

        return ApiResponse.onSuccess(healthResponseDTO);

    }
}
