package com.mpp.findy.core.model.product;

import com.mpp.findy.core.enums.PlatformsEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table()
public class FindyProductBo {

    private Long id;
    private String name;
    private String description;
    private String websiteUrl;
}
