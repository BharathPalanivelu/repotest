package com.shopee.app.web.protocol;

public class SearchUserData {
    private boolean isOfficialShopOnly;
    private String keyword;

    public String getKeyword() {
        return this.keyword;
    }

    public boolean isOfficialShopOnly() {
        return this.isOfficialShopOnly;
    }
}
