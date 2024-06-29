package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Plan extends MutableBaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "plan_id")
    private Long id; // PK

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String title; // 제목

    @Size(max = 500)
    @Column(nullable = true, length = 500)
    private String description; // 설명

    @DecimalMin("0.0")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price; // 가격

    @Column(nullable = false)
    private LocalTime billingCycle; // 결제 주기
}
