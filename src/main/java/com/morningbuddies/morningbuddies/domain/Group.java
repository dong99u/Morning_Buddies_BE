package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import com.morningbuddies.morningbuddies.domain.mapping.GroupGame;
import com.morningbuddies.morningbuddies.domain.mapping.MemberGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "`groups`") // sql 키워드와 겹치는 이름을 사용할 때는 이렇게 테이블명을 지정해주어야 한다.
public class Group extends MutableBaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private Long id; // PK

    @NotBlank
    @Size(max = 30)
    @Column(nullable = false, unique = true, length = 30)
    private String groupName; // 그룹 이름

    @Size(max = 200)
    @Column(nullable = true, length = 200)
    private String description; // 그룹 설명

    private LocalTime wakeUpTime; // 기상 시간

    @Column(nullable = false)
    private int successCount; // 성공 횟수

    @Column(nullable = false)
    private boolean isActivated; // 활성화 여부

    private LocalTime timeOut; // 타임아웃 시간

    @Column(nullable = true)
    private String groupImageUrl; // 그룹 이미지 URL

    @Min(1)
    @Max(10)
    @Column(nullable = false)
    private int maxParticipants; // 최대 참가자 수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id", nullable = false) // 방장은 무조건 있어야 하므로 nullable = false
    private Member leader; // 그룹장

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<MemberGroup> memberGroups = new ArrayList<>();

    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    private GroupGame groupGame; // 그룹 게임

    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    private Alarm alarm; // 알람

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>(); // 알림
}
