package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import com.morningbuddies.morningbuddies.domain.enums.RefundStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Refund extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "refund_id")
    private Long id; // PK

    @DecimalMin("0.0")
    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price; // 가격

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private RefundStatus refundStatus; // 환불 상태

    @Size(max = 500)
    @Column(nullable = true, length = 500)
    private String message; // 메시지

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription; // 구독
}
