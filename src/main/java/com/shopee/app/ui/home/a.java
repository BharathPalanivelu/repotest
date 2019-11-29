package com.shopee.app.ui.home;

import com.shopee.id.R;

public enum a {
    TAB_HOME_WEB("TAB_HOME_WEB", 0, R.string.sp_home_tab_buy, R.drawable.ic_home, R.drawable.ic_home_selected),
    TAB_HOME_RN("TAB_HOME_RN", 0, R.string.sp_home_tab_buy, R.drawable.ic_home, R.drawable.ic_home_selected),
    TAB_FEED("TAB_FEED", 1, R.string.sp_home_tab_home, R.drawable.ic_feed_line, R.drawable.ic_feed_colorlump),
    TAB_SELL("TAB_SELL", 2, R.string.sp_home_tab_sell, R.drawable.ic_sell_line, R.drawable.ic_sell_line),
    TAB_MALL_WEB("TAB_MALL_WEB", 2, R.string.sp_home_tab_mall, R.drawable.ic_mall, R.drawable.ic_mall_selected),
    TAB_MALL_RN("TAB_MALL_WEB", 2, R.string.sp_home_tab_mall, R.drawable.ic_mall, R.drawable.ic_mall_selected),
    TAB_LIVE_STREAMING("TAB_LIVE_STREAMING", 2, R.string.sp_home_tab_live_streaming, R.drawable.ic_livestreaming_line, R.drawable.ic_livestreaming_selected),
    TAB_NOTIFICATION("TAB_NOTIFICATION", 3, R.string.sp_notifications, R.drawable.ic_notifications_line, R.drawable.ic_notifications_colorlump),
    TAB_ME("TAB_ME", 4, R.string.sp_home_tab_me, R.drawable.ic_me_line, R.drawable.ic_me_colorlump);
    
    private final int mIconActiveResId;
    private final int mIconResId;
    private final String mId;
    private final int mPos;
    private final int mTitleRes;

    private a(String str, int i, int i2, int i3, int i4) {
        this.mPos = i;
        this.mId = str;
        this.mTitleRes = i2;
        this.mIconResId = i3;
        this.mIconActiveResId = i4;
    }

    public String getId() {
        return this.mId;
    }

    public int getPos() {
        return this.mPos;
    }

    public int getIconResId() {
        return this.mIconResId;
    }

    public int getIconActiveResId() {
        return this.mIconActiveResId;
    }

    public int getTitleResId() {
        return this.mTitleRes;
    }
}
