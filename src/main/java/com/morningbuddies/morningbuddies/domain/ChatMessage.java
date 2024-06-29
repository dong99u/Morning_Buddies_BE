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
public class ChatMessage extends MutableBaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "chat_message_id")
    private Long id; // PK

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message; // 메시지

    @Column(nullable = false)
    private LocalDateTime sendTime; // 보낸 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private Member sender; // 보낸 사람


}
