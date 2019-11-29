package com.salesforce.android.service.common.utilities.internal.connectivity;

public enum Technology {
    WIFI(1),
    RADIO(0);
    
    private final int mType;

    private Technology(int i) {
        this.mType = i;
    }

    static Technology fromType(int i) {
        for (Technology technology : values()) {
            if (technology.mType == i) {
                return technology;
            }
        }
        return WIFI;
    }
}
