package com.mpp.domain;

import com.mpp.enums.PlatformsEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class FindyEndpointSearch {

    private UUID headerId;
    private PlatformsEnum platformHandler;
}
