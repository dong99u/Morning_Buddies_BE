package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import com.morningbuddies.morningbuddies.domain.enums.GameType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Game extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "game_id")
    private Long id; // PK

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name; // 게임 이름

    @Size(max = 500)
    @Column(nullable = true, length = 500)
    private String description; // 게임 설명

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GameType gameType; // 게임 유형

    @Min(1)
    @Max(3)
    @Column(nullable = false)
    private int difficulty; // 난이도
}
