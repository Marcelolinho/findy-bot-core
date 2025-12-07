package com.mpp.findy.core.model.bot;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "findy_bot_platform", uniqueConstraints = {
        @UniqueConstraint(name = "ck_platform", columnNames = {"name"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindyBotPlatform {

    @Id
    @GeneratedValue(generator = "gen_bot_platform_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_bot_platform_id", allocationSize = 1, sequenceName = "gen_bot_platform_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "findy_bot_platform_users",
            joinColumns = @JoinColumn(name = "bot_platform_id"),
            inverseJoinColumns = @JoinColumn(name = "bot_user_id")
    )
    private Set<FindyBotUser> users;
}
