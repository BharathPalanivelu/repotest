package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ExtendOrder extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public ExtendOrder(String str, Long l, String str2, BackendParam backendParam) {
        this.requestid = str;
        this.orderid = l;
        this.token = str2;
        this.bparam = backendParam;
    }

    private ExtendOrder(Builder builder) {
        this(builder.requestid, builder.orderid, builder.token, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExtendOrder)) {
            return false;
        }
        ExtendOrder extendOrder = (ExtendOrder) obj;
        if (!equals((Object) this.requestid, (Object) extendOrder.requestid) || !equals((Object) this.orderid, (Object) extendOrder.orderid) || !equals((Object) this.token, (Object) extendOrder.token) || !equals((Object) this.bparam, (Object) extendOrder.bparam)) {
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
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ExtendOrder> {
        public BackendParam bparam;
        public Long orderid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ExtendOrder extendOrder) {
            super(extendOrder);
            if (extendOrder != null) {
                this.requestid = extendOrder.requestid;
                this.orderid = extendOrder.orderid;
                this.token = extendOrder.token;
                this.bparam = extendOrder.bparam;
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public ExtendOrder build() {
            checkRequiredFields();
            return new ExtendOrder(this);
        }
    }
}
