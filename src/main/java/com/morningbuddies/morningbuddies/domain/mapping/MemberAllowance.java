package com.morningbuddies.morningbuddies.domain.mapping;

import com.morningbuddies.morningbuddies.domain.Allowance;
import com.morningbuddies.morningbuddies.domain.Member;
import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAllowance extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_allowance_id")
    private Long id; // PK

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "allowance_id")
    private Allowance allowance;

}
