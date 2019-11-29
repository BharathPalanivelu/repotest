package com.shopee.app.data.viewmodel;

import com.garena.android.appkit.tools.b;

public class MeTabNoticeItem {
    private int actionId;
    private int buttonText;
    private int iconRes;
    private ShopDetail shop;
    private String text;

    private MeTabNoticeItem(Builder builder) {
        this.text = builder.text;
        this.buttonText = builder.buttonText;
        this.iconRes = builder.iconRes;
        this.actionId = builder.actionId;
        this.shop = builder.shop;
    }

    public String getText() {
        return this.text;
    }

    public int getButtonText() {
        return this.buttonText;
    }

    public int getIconRes() {
        return this.iconRes;
    }

    public int getActionId() {
        return this.actionId;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int actionId;
        /* access modifiers changed from: private */
        public int buttonText;
        /* access modifiers changed from: private */
        public int iconRes;
        /* access modifiers changed from: private */
        public ShopDetail shop;
        /* access modifiers changed from: private */
        public String text;

        public Builder text(int i) {
            this.text = b.e(i);
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder buttonText(int i) {
            this.buttonText = i;
            return this;
        }

        public Builder iconRes(int i) {
            this.iconRes = i;
            return this;
        }

        public Builder actionId(int i) {
            this.actionId = i;
            return this;
        }

        public Builder shop(ShopDetail shopDetail) {
            this.shop = shopDetail;
            return this;
        }

        public MeTabNoticeItem build() {
            return new MeTabNoticeItem(this);
        }
    }
}
