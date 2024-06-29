package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Notification extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "notification_id")
    private Long id; // PK

    @NotBlank
    @Column(nullable = false, length = 500)
    private String content; // 알림 내용

    @Column(nullable = false)
    private boolean isRead; // 읽음 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

}
