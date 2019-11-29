package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCheckoutId extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCheckoutId(String str, Integer num, Long l) {
        this.requestid = str;
        this.errcode = num;
        this.checkoutid = l;
    }

    private ResponseCheckoutId(Builder builder) {
        this(builder.requestid, builder.errcode, builder.checkoutid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCheckoutId)) {
            return false;
        }
        ResponseCheckoutId responseCheckoutId = (ResponseCheckoutId) obj;
        if (!equals((Object) this.requestid, (Object) responseCheckoutId.requestid) || !equals((Object) this.errcode, (Object) responseCheckoutId.errcode) || !equals((Object) this.checkoutid, (Object) responseCheckoutId.checkoutid)) {
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
        Long l = this.checkoutid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCheckoutId> {
        public Long checkoutid;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCheckoutId responseCheckoutId) {
            super(responseCheckoutId);
            if (responseCheckoutId != null) {
                this.requestid = responseCheckoutId.requestid;
                this.errcode = responseCheckoutId.errcode;
                this.checkoutid = responseCheckoutId.checkoutid;
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

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public ResponseCheckoutId build() {
            checkRequiredFields();
            return new ResponseCheckoutId(this);
        }
    }
}
