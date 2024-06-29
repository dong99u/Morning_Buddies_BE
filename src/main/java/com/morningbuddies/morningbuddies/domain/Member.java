package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import com.morningbuddies.morningbuddies.domain.enums.SocialMedia;
import com.morningbuddies.morningbuddies.domain.mapping.MemberGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "member")
public class Member extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id; // PK

    @Email
    @Column(nullable = false, unique = true, length = 50, updatable = false)
    private String email; // 이메일 (아이디)

    @NotBlank
    @Column(nullable = false, length = 30)
    private String password; // 비밀번호

    @NotBlank
    @Column(nullable = false, updatable = false, length = 30)
    private String username; // 이름

    @Embedded
    private Address address; // 주소

    @Column(nullable = true)
    private String profileImageUrl; // 프로필 이미지 URL

    @Column(nullable = true)
    private LocalTime preferredWakeUpTime; // 선호하는 기상 시간

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private SocialMedia socialMedia; // 소셜 미디어 종류

    @Column(nullable = false, unique = true)
    private String phoneNumber; // 전화번호

    @Column(nullable = false)
    private boolean isActivated; // 활성화 여부

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberGroup> memberGroups = new ArrayList<>();

}
