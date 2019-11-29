package com.shopee.app.web.protocol;

public final class SearchConfigExtInfo {
    private final String domainType;

    public SearchConfigExtInfo(String str) {
        this.domainType = str;
    }

    public final String getDomainType() {
        return this.domainType;
    }
}
