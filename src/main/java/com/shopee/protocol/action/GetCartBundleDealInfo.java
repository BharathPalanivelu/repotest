package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCartBundleDealInfo extends Message {
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetCartBundleDealInfo(String str, String str2, Long l) {
        this.requestid = str;
        this.token = str2;
        this.bundle_deal_id = l;
    }

    private GetCartBundleDealInfo(Builder builder) {
        this(builder.requestid, builder.token, builder.bundle_deal_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCartBundleDealInfo)) {
            return false;
        }
        GetCartBundleDealInfo getCartBundleDealInfo = (GetCartBundleDealInfo) obj;
        if (!equals((Object) this.requestid, (Object) getCartBundleDealInfo.requestid) || !equals((Object) this.token, (Object) getCartBundleDealInfo.token) || !equals((Object) this.bundle_deal_id, (Object) getCartBundleDealInfo.bundle_deal_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.bundle_deal_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCartBundleDealInfo> {
        public Long bundle_deal_id;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetCartBundleDealInfo getCartBundleDealInfo) {
            super(getCartBundleDealInfo);
            if (getCartBundleDealInfo != null) {
                this.requestid = getCartBundleDealInfo.requestid;
                this.token = getCartBundleDealInfo.token;
                this.bundle_deal_id = getCartBundleDealInfo.bundle_deal_id;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public GetCartBundleDealInfo build() {
            return new GetCartBundleDealInfo(this);
        }
    }
}
