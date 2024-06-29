package com.morningbuddies.morningbuddies.domain.mapping;

import com.morningbuddies.morningbuddies.domain.Game;
import com.morningbuddies.morningbuddies.domain.Group;
import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class GroupGame extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "group_game_id")
    private Long id; // PK

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

}
