package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCheckoutOrder extends Message {
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetCheckoutOrder(String str, String str2, Long l) {
        this.requestid = str;
        this.token = str2;
        this.checkoutid = l;
    }

    private GetCheckoutOrder(Builder builder) {
        this(builder.requestid, builder.token, builder.checkoutid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCheckoutOrder)) {
            return false;
        }
        GetCheckoutOrder getCheckoutOrder = (GetCheckoutOrder) obj;
        if (!equals((Object) this.requestid, (Object) getCheckoutOrder.requestid) || !equals((Object) this.token, (Object) getCheckoutOrder.token) || !equals((Object) this.checkoutid, (Object) getCheckoutOrder.checkoutid)) {
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
        Long l = this.checkoutid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCheckoutOrder> {
        public Long checkoutid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetCheckoutOrder getCheckoutOrder) {
            super(getCheckoutOrder);
            if (getCheckoutOrder != null) {
                this.requestid = getCheckoutOrder.requestid;
                this.token = getCheckoutOrder.token;
                this.checkoutid = getCheckoutOrder.checkoutid;
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

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public GetCheckoutOrder build() {
            return new GetCheckoutOrder(this);
        }
    }
}
