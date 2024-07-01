package com.morningbuddies.morningbuddies.web.dto.health;

import lombok.*;

public class HealthResponse {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class HealthResponseDTO {

        private String message;

    }
}
