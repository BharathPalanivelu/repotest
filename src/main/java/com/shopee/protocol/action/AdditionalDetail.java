package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdditionalDetail extends Message {
    public static final String DEFAULT_APP_VERSION = "";
    public static final String DEFAULT_SOURCE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String app_version;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String source;

    public AdditionalDetail(String str, String str2) {
        this.app_version = str;
        this.source = str2;
    }

    private AdditionalDetail(Builder builder) {
        this(builder.app_version, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdditionalDetail)) {
            return false;
        }
        AdditionalDetail additionalDetail = (AdditionalDetail) obj;
        if (!equals((Object) this.app_version, (Object) additionalDetail.app_version) || !equals((Object) this.source, (Object) additionalDetail.source)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.app_version;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.source;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdditionalDetail> {
        public String app_version;
        public String source;

        public Builder() {
        }

        public Builder(AdditionalDetail additionalDetail) {
            super(additionalDetail);
            if (additionalDetail != null) {
                this.app_version = additionalDetail.app_version;
                this.source = additionalDetail.source;
            }
        }

        public Builder app_version(String str) {
            this.app_version = str;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public AdditionalDetail build() {
            return new AdditionalDetail(this);
        }
    }
}
