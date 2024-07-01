package com.morningbuddies.morningbuddies.converter;

import com.morningbuddies.morningbuddies.web.dto.health.HealthResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class HealthConverter {

    public static HealthResponse.HealthResponseDTO toHealthResponseDTO(String message) {
        return HealthResponse.HealthResponseDTO.builder()
                .message(message)
                .build();
    }
}
