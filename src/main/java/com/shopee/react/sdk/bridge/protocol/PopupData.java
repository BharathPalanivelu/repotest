package com.shopee.react.sdk.bridge.protocol;

import com.google.a.l;

public class PopupData {
    private String cancelText;
    private String content;
    private l contentView;
    private int contentViewType;
    private boolean isAutoDismiss = true;
    private String okText;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        String str = this.content;
        return str == null ? "" : str;
    }

    public String getOkText() {
        return this.okText;
    }

    public String getCancelText() {
        return this.cancelText;
    }

    public boolean isAutoDismiss() {
        return this.isAutoDismiss;
    }

    public int getContentViewType() {
        return this.contentViewType;
    }

    public l getContentView() {
        return this.contentView;
    }
}
