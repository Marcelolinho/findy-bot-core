package com.mpp.findy.core.model.bot;

import com.mpp.findy.core.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "findy_bot_message")
public class FindyBotMessage extends BaseEntity {

    @Id
    @GeneratedValue(generator = "gen_bot_message_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_bot_message_id", allocationSize = 1, sequenceName = "gen_bot_message_id")
    private Long id;

    @Column(name = "size_in_bytes")
    private Long sizeInBytes;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "id_bot_user", nullable = false)
    private FindyBotUser user;
}
