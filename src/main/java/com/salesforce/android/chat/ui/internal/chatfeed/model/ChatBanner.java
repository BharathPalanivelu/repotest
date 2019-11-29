package com.salesforce.android.chat.ui.internal.chatfeed.model;

public class ChatBanner {
    private int mChatBannerLayoutViewId;

    public ChatBanner(int i) {
        this.mChatBannerLayoutViewId = i;
    }

    public int getLayoutRes() {
        return this.mChatBannerLayoutViewId;
    }
}
