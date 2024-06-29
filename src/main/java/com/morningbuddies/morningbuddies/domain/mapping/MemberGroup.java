package com.morningbuddies.morningbuddies.domain.mapping;

import com.morningbuddies.morningbuddies.domain.Group;
import com.morningbuddies.morningbuddies.domain.Member;
import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member_group")
public class MemberGroup extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_group_id")
    private Long id; // PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;


}
