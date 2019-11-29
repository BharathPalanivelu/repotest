package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TargetAdsRespInfo extends Message {
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final Long DEFAULT_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 3)
    public final TargetAdsReqInfo info;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long price;

    public TargetAdsRespInfo(ResponseHeader responseHeader, Long l, TargetAdsReqInfo targetAdsReqInfo, String str) {
        this.header = responseHeader;
        this.price = l;
        this.info = targetAdsReqInfo;
        this.err_message = str;
    }

    private TargetAdsRespInfo(Builder builder) {
        this(builder.header, builder.price, builder.info, builder.err_message);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TargetAdsRespInfo)) {
            return false;
        }
        TargetAdsRespInfo targetAdsRespInfo = (TargetAdsRespInfo) obj;
        if (!equals((Object) this.header, (Object) targetAdsRespInfo.header) || !equals((Object) this.price, (Object) targetAdsRespInfo.price) || !equals((Object) this.info, (Object) targetAdsRespInfo.info) || !equals((Object) this.err_message, (Object) targetAdsRespInfo.err_message)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        Long l = this.price;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        TargetAdsReqInfo targetAdsReqInfo = this.info;
        int hashCode3 = (hashCode2 + (targetAdsReqInfo != null ? targetAdsReqInfo.hashCode() : 0)) * 37;
        String str = this.err_message;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TargetAdsRespInfo> {
        public String err_message;
        public ResponseHeader header;
        public TargetAdsReqInfo info;
        public Long price;

        public Builder() {
        }

        public Builder(TargetAdsRespInfo targetAdsRespInfo) {
            super(targetAdsRespInfo);
            if (targetAdsRespInfo != null) {
                this.header = targetAdsRespInfo.header;
                this.price = targetAdsRespInfo.price;
                this.info = targetAdsRespInfo.info;
                this.err_message = targetAdsRespInfo.err_message;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder info(TargetAdsReqInfo targetAdsReqInfo) {
            this.info = targetAdsReqInfo;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public TargetAdsRespInfo build() {
            return new TargetAdsRespInfo(this);
        }
    }
}
