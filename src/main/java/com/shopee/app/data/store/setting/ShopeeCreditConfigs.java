package com.shopee.app.data.store.setting;

import android.text.TextUtils;

public class ShopeeCreditConfigs {
    private String logo;
    private String title;
    private String url;

    public String getTitle() {
        return this.title;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isEnabled() {
        return !TextUtils.isEmpty(this.title) && !TextUtils.isEmpty(this.logo) && !TextUtils.isEmpty(this.url);
    }
}
