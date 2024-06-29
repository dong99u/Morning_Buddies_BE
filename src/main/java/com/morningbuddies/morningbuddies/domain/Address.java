package com.morningbuddies.morningbuddies.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Address {

    @NotBlank
    private String address;

    @NotBlank
    private String addressDetail;

    @NotBlank
    private String zipCode;
}
