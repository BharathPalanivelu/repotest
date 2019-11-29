package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PayOrder extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_PAID_AMOUNT = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long paid_amount;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public PayOrder(String str, Long l, Long l2, BackendParam backendParam, String str2) {
        this.requestid = str;
        this.orderid = l;
        this.paid_amount = l2;
        this.bparam = backendParam;
        this.token = str2;
    }

    private PayOrder(Builder builder) {
        this(builder.requestid, builder.orderid, builder.paid_amount, builder.bparam, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayOrder)) {
            return false;
        }
        PayOrder payOrder = (PayOrder) obj;
        if (!equals((Object) this.requestid, (Object) payOrder.requestid) || !equals((Object) this.orderid, (Object) payOrder.orderid) || !equals((Object) this.paid_amount, (Object) payOrder.paid_amount) || !equals((Object) this.bparam, (Object) payOrder.bparam) || !equals((Object) this.token, (Object) payOrder.token)) {
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
        Long l2 = this.paid_amount;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PayOrder> {
        public BackendParam bparam;
        public Long orderid;
        public Long paid_amount;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(PayOrder payOrder) {
            super(payOrder);
            if (payOrder != null) {
                this.requestid = payOrder.requestid;
                this.orderid = payOrder.orderid;
                this.paid_amount = payOrder.paid_amount;
                this.bparam = payOrder.bparam;
                this.token = payOrder.token;
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

        public Builder paid_amount(Long l) {
            this.paid_amount = l;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public PayOrder build() {
            checkRequiredFields();
            return new PayOrder(this);
        }
    }
}
