package com.shopee.protocol.action;

import com.shopee.protocol.shop.BundleDeal;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetBundleDeal extends Message {
    public static final List<BundleDeal> DEFAULT_BUNDLE_DEALS = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = BundleDeal.class, tag = 3)
    public final List<BundleDeal> bundle_deals;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetBundleDeal(String str, Integer num, List<BundleDeal> list) {
        this.requestid = str;
        this.errcode = num;
        this.bundle_deals = immutableCopyOf(list);
    }

    private ResponseGetBundleDeal(Builder builder) {
        this(builder.requestid, builder.errcode, builder.bundle_deals);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetBundleDeal)) {
            return false;
        }
        ResponseGetBundleDeal responseGetBundleDeal = (ResponseGetBundleDeal) obj;
        if (!equals((Object) this.requestid, (Object) responseGetBundleDeal.requestid) || !equals((Object) this.errcode, (Object) responseGetBundleDeal.errcode) || !equals((List<?>) this.bundle_deals, (List<?>) responseGetBundleDeal.bundle_deals)) {
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
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<BundleDeal> list = this.bundle_deals;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseGetBundleDeal> {
        public List<BundleDeal> bundle_deals;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetBundleDeal responseGetBundleDeal) {
            super(responseGetBundleDeal);
            if (responseGetBundleDeal != null) {
                this.requestid = responseGetBundleDeal.requestid;
                this.errcode = responseGetBundleDeal.errcode;
                this.bundle_deals = ResponseGetBundleDeal.copyOf(responseGetBundleDeal.bundle_deals);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder bundle_deals(List<BundleDeal> list) {
            this.bundle_deals = checkForNulls(list);
            return this;
        }

        public ResponseGetBundleDeal build() {
            return new ResponseGetBundleDeal(this);
        }
    }
}
