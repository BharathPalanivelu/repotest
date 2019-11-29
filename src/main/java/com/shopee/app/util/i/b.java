package com.shopee.app.util.i;

public enum b {
    NDEF_DISCOVERED("android.nfc.action.NDEF_DISCOVERED"),
    TECH_DISCOVERED("android.nfc.action.TECH_DISCOVERED"),
    TAG_DISCOVERED("android.nfc.action.TAG_DISCOVERED");
    
    private final String filterName;

    private b(String str) {
        this.filterName = str;
    }

    public final String getFilterName() {
        return this.filterName;
    }
}
