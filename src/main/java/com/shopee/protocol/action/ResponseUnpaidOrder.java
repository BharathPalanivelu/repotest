package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseUnpaidOrder extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3)
    public final UnpaidOrder unpaid_order;

    public ResponseUnpaidOrder(String str, Integer num, UnpaidOrder unpaidOrder) {
        this.requestid = str;
        this.errcode = num;
        this.unpaid_order = unpaidOrder;
    }

    private ResponseUnpaidOrder(Builder builder) {
        this(builder.requestid, builder.errcode, builder.unpaid_order);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUnpaidOrder)) {
            return false;
        }
        ResponseUnpaidOrder responseUnpaidOrder = (ResponseUnpaidOrder) obj;
        if (!equals((Object) this.requestid, (Object) responseUnpaidOrder.requestid) || !equals((Object) this.errcode, (Object) responseUnpaidOrder.errcode) || !equals((Object) this.unpaid_order, (Object) responseUnpaidOrder.unpaid_order)) {
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
        UnpaidOrder unpaidOrder = this.unpaid_order;
        if (unpaidOrder != null) {
            i2 = unpaidOrder.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseUnpaidOrder> {
        public Integer errcode;
        public String requestid;
        public UnpaidOrder unpaid_order;

        public Builder() {
        }

        public Builder(ResponseUnpaidOrder responseUnpaidOrder) {
            super(responseUnpaidOrder);
            if (responseUnpaidOrder != null) {
                this.requestid = responseUnpaidOrder.requestid;
                this.errcode = responseUnpaidOrder.errcode;
                this.unpaid_order = responseUnpaidOrder.unpaid_order;
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

        public Builder unpaid_order(UnpaidOrder unpaidOrder) {
            this.unpaid_order = unpaidOrder;
            return this;
        }

        public ResponseUnpaidOrder build() {
            checkRequiredFields();
            return new ResponseUnpaidOrder(this);
        }
    }
}
