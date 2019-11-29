package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetUnpaidOrder extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public GetUnpaidOrder(String str, Long l, String str2) {
        this.requestid = str;
        this.checkoutid = l;
        this.token = str2;
    }

    private GetUnpaidOrder(Builder builder) {
        this(builder.requestid, builder.checkoutid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUnpaidOrder)) {
            return false;
        }
        GetUnpaidOrder getUnpaidOrder = (GetUnpaidOrder) obj;
        if (!equals((Object) this.requestid, (Object) getUnpaidOrder.requestid) || !equals((Object) this.checkoutid, (Object) getUnpaidOrder.checkoutid) || !equals((Object) this.token, (Object) getUnpaidOrder.token)) {
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
        Long l = this.checkoutid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetUnpaidOrder> {
        public Long checkoutid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetUnpaidOrder getUnpaidOrder) {
            super(getUnpaidOrder);
            if (getUnpaidOrder != null) {
                this.requestid = getUnpaidOrder.requestid;
                this.checkoutid = getUnpaidOrder.checkoutid;
                this.token = getUnpaidOrder.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetUnpaidOrder build() {
            return new GetUnpaidOrder(this);
        }
    }
}
