package com.morningbuddies.morningbuddies.domain.common;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class MutableBaseEntity extends BaseEntity {
    @LastModifiedDate
    @Column(updatable = true)
    private LocalDateTime modifiedAt;

    @LastModifiedBy
    @Column(updatable = true)
    private String modifiedBy;

}
