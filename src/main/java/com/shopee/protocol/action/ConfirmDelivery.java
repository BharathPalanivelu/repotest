package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConfirmDelivery extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public ConfirmDelivery(String str, String str2, Integer num, Long l, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.shopid = num;
        this.orderid = l;
        this.bparam = backendParam;
    }

    private ConfirmDelivery(Builder builder) {
        this(builder.requestid, builder.token, builder.shopid, builder.orderid, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfirmDelivery)) {
            return false;
        }
        ConfirmDelivery confirmDelivery = (ConfirmDelivery) obj;
        if (!equals((Object) this.requestid, (Object) confirmDelivery.requestid) || !equals((Object) this.token, (Object) confirmDelivery.token) || !equals((Object) this.shopid, (Object) confirmDelivery.shopid) || !equals((Object) this.orderid, (Object) confirmDelivery.orderid) || !equals((Object) this.bparam, (Object) confirmDelivery.bparam)) {
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
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConfirmDelivery> {
        public BackendParam bparam;
        public Long orderid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(ConfirmDelivery confirmDelivery) {
            super(confirmDelivery);
            if (confirmDelivery != null) {
                this.requestid = confirmDelivery.requestid;
                this.token = confirmDelivery.token;
                this.shopid = confirmDelivery.shopid;
                this.orderid = confirmDelivery.orderid;
                this.bparam = confirmDelivery.bparam;
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

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public ConfirmDelivery build() {
            checkRequiredFields();
            return new ConfirmDelivery(this);
        }
    }
}
