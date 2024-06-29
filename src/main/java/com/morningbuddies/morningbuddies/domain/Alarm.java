package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Alarm extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "alarm_id")
    private Long id; // PK

    private LocalDateTime alarmTime; // 알람 시간

    private boolean isActivated; // 활성화 여부

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group; // 그룹

}
