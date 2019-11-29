package com.shopee.react.sdk.bridge.protocol;

public class PopupResponse {
    private int action;
    private String value;

    private PopupResponse(Builder builder) {
        this.action = builder.action;
        this.value = builder.value;
    }

    public int getAction() {
        return this.action;
    }

    public String getValue() {
        return this.value;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int action;
        /* access modifiers changed from: private */
        public String value;

        public Builder action(int i) {
            this.action = i;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public PopupResponse build() {
            return new PopupResponse(this);
        }
    }
}
