package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import com.morningbuddies.morningbuddies.domain.enums.PaymentMethod;
import com.morningbuddies.morningbuddies.domain.enums.PaymentResultStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Payment extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private Long id; // PK

    @Column(name = "price", nullable = false, precision = 19, scale = 4)
    private BigDecimal price; // 가격

    @Column(nullable = false)
    private LocalDateTime paymentTime; // 결제 시간

    @Column(nullable = true)
    private LocalDateTime successedAt; // 결제 성공 시간

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod; // 결제 수단

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private PaymentResultStatus paymentResultStatus; // 결제 결과 상태

    @Column(nullable = true, length = 255)
    private String paymentResultMessage; // 결제 결과 메시지

    @Column(nullable = true, length = 100)
    private String billingKey; // 빌링 키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 회원



}
