package com.morningbuddies.morningbuddies.domain;

import com.morningbuddies.morningbuddies.domain.common.MutableBaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Allowance extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "allowance_id")
    private Long id; // PK

    @Column(nullable = false, length = 50)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;
}
