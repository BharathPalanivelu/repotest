package com.salesforce.android.chat.ui.internal.chatfeed.model;

public class Notice {
    private final int mNoticeText;

    Notice(int i) {
        this.mNoticeText = i;
    }

    public int getNoticeText() {
        return this.mNoticeText;
    }
}
