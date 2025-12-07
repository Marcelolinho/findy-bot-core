package com.mpp.findy.core.enums;

public enum UserPlanEnum {
    FREE("FREE"),
    STARTER_PREMIUM("STARTER_PREMIUM"),
    FULL_PREMIUM("FULL_PREMIUM"),
    ADMIN("ADMIN");

    private String value;

    UserPlanEnum(String value) {
        this.value = value;
    }
}
