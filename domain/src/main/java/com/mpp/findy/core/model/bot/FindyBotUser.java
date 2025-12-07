package com.mpp.findy.core.model.bot;

import com.mpp.findy.core.enums.UserPlanEnum;
import com.mpp.findy.core.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "findy_bot_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindyBotUser extends BaseEntity {

    @Id
    @GeneratedValue(generator = "gen_bot_user_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_bot_user_id", allocationSize = 1, sequenceName = "gen_bot_user_id")
    private Long id;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "phone_number", nullable = false)
    @NumberFormat
    private String phoneNumber;

    @Column(name = "plan", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserPlanEnum plan;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FindyBotMessage> messages;

    @ManyToMany(mappedBy = "users")
    private Set<FindyBotPlatform> platforms;
}
