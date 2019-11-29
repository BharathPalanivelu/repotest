package com.salesforce.android.chat.ui.internal.linkpreview;

public class OGMetadata {
    private String mOgDescription;
    private String mOgImageUrl;
    private String mOgTitle;
    private String mOgUrl;

    OGMetadata(Builder builder) {
        this.mOgTitle = builder.mOgTitle;
        this.mOgDescription = builder.mOgDescription;
        this.mOgUrl = builder.mOgUrl;
        this.mOgImageUrl = builder.mOgImageUrl;
    }

    public final String getOGTitle() {
        return this.mOgTitle;
    }

    public final String getOGDescription() {
        return this.mOgDescription;
    }

    public final String getOGUrl() {
        return this.mOgUrl;
    }

    public final String getOGImageUrl() {
        return this.mOgImageUrl;
    }

    static class Builder {
        /* access modifiers changed from: private */
        public String mOgDescription;
        /* access modifiers changed from: private */
        public String mOgImageUrl;
        /* access modifiers changed from: private */
        public String mOgTitle;
        /* access modifiers changed from: private */
        public String mOgUrl;

        Builder() {
        }

        public Builder ogTitle(String str) {
            this.mOgTitle = str;
            return this;
        }

        public Builder ogDescription(String str) {
            this.mOgDescription = str;
            return this;
        }

        public Builder ogUrl(String str) {
            this.mOgUrl = str;
            return this;
        }

        public Builder ogImageUrl(String str) {
            this.mOgImageUrl = str;
            return this;
        }

        public OGMetadata build() {
            return new OGMetadata(this);
        }
    }
}
