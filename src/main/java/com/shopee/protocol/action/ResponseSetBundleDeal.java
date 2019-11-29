package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseSetBundleDeal extends Message {
    public static final Long DEFAULT_BUNDLE_DEAL_ID = 0L;
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long bundle_deal_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetBundleDeal(String str, Integer num, Long l, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.bundle_deal_id = l;
        this.debug_msg = str2;
    }

    private ResponseSetBundleDeal(Builder builder) {
        this(builder.requestid, builder.errcode, builder.bundle_deal_id, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetBundleDeal)) {
            return false;
        }
        ResponseSetBundleDeal responseSetBundleDeal = (ResponseSetBundleDeal) obj;
        if (!equals((Object) this.requestid, (Object) responseSetBundleDeal.requestid) || !equals((Object) this.errcode, (Object) responseSetBundleDeal.errcode) || !equals((Object) this.bundle_deal_id, (Object) responseSetBundleDeal.bundle_deal_id) || !equals((Object) this.debug_msg, (Object) responseSetBundleDeal.debug_msg)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.bundle_deal_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSetBundleDeal> {
        public Long bundle_deal_id;
        public String debug_msg;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetBundleDeal responseSetBundleDeal) {
            super(responseSetBundleDeal);
            if (responseSetBundleDeal != null) {
                this.requestid = responseSetBundleDeal.requestid;
                this.errcode = responseSetBundleDeal.errcode;
                this.bundle_deal_id = responseSetBundleDeal.bundle_deal_id;
                this.debug_msg = responseSetBundleDeal.debug_msg;
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

        public Builder bundle_deal_id(Long l) {
            this.bundle_deal_id = l;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponseSetBundleDeal build() {
            return new ResponseSetBundleDeal(this);
        }
    }
}
