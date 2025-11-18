package com.mpp.scraper.core.enums;

public enum PriceTypeEnum {
    NORMAL("NORMAL"),
    PROMOTION("PROMOTION");

    private String value;

    PriceTypeEnum(String val) {
        this.value = val;
    }
}
