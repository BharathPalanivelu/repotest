package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetRefundByOrder extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public GetRefundByOrder(String str, Long l, String str2) {
        this.requestid = str;
        this.orderid = l;
        this.token = str2;
    }

    private GetRefundByOrder(Builder builder) {
        this(builder.requestid, builder.orderid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetRefundByOrder)) {
            return false;
        }
        GetRefundByOrder getRefundByOrder = (GetRefundByOrder) obj;
        if (!equals((Object) this.requestid, (Object) getRefundByOrder.requestid) || !equals((Object) this.orderid, (Object) getRefundByOrder.orderid) || !equals((Object) this.token, (Object) getRefundByOrder.token)) {
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
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetRefundByOrder> {
        public Long orderid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetRefundByOrder getRefundByOrder) {
            super(getRefundByOrder);
            if (getRefundByOrder != null) {
                this.requestid = getRefundByOrder.requestid;
                this.orderid = getRefundByOrder.orderid;
                this.token = getRefundByOrder.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public GetRefundByOrder build() {
            return new GetRefundByOrder(this);
        }
    }
}
