package com.shopee.app.web.protocol;

import com.shopee.id.R;

public class ConfigureButtonMessage {
    public static final String ICON_TYPE_EDIT_PRODUCT = "editProduct";
    public static final String ICON_TYPE_FILTER = "filter";
    public static final String ICON_TYPE_FILTER_APPLIED = "filterApplied";
    private String iconType;
    private String key;
    private int webviewId;

    public String getIconType() {
        return this.iconType;
    }

    public String getKey() {
        return this.key;
    }

    public int getIconDrawable() {
        if ("filter".equals(this.iconType)) {
            return R.drawable.com_garena_shopee_ic_filter;
        }
        if ("filterApplied".equals(this.iconType)) {
            return R.drawable.com_garena_shopee_ic_filtered;
        }
        return "editProduct".equals(this.iconType) ? R.drawable.com_garena_shopee_ic_edit_primary : R.drawable.action_bar_button_background;
    }

    public void setWebviewId(int i) {
        this.webviewId = i;
    }

    public int getWebviewId() {
        return this.webviewId;
    }
}
