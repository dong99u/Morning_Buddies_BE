package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Subscription extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "subscription_id")
    private Long id; // PK

    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    private LocalDateTime startedAt; // 시작 시간

    @FutureOrPresent
    @Column(nullable = true)
    private LocalDateTime endedAt; // 종료 시간

    @Column(nullable = false)
    private boolean isCanceled; // 취소 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @OneToOne(mappedBy = "subscription", cascade = CascadeType.ALL)
    private Refund refund;

}
