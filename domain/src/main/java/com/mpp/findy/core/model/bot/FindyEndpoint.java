package com.mpp.findy.core.model.bot;

import com.mpp.findy.core.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "findy_endpoint")
public class FindyEndpoint extends BaseEntity {

    @Id
    @SequenceGenerator(name = "seq_endpoint_id", allocationSize = 1, sequenceName = "gen_endpoint_id")
    @GeneratedValue(generator = "gen_endpoint_id", strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Column(name = "")

}
