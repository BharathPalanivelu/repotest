package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RevisePrice extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6)
    public final BackendParam bparam;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long shipping_fee;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public RevisePrice(String str, Integer num, Long l, Long l2, String str2, BackendParam backendParam) {
        this.requestid = str;
        this.shopid = num;
        this.orderid = l;
        this.shipping_fee = l2;
        this.token = str2;
        this.bparam = backendParam;
    }

    private RevisePrice(Builder builder) {
        this(builder.requestid, builder.shopid, builder.orderid, builder.shipping_fee, builder.token, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RevisePrice)) {
            return false;
        }
        RevisePrice revisePrice = (RevisePrice) obj;
        if (!equals((Object) this.requestid, (Object) revisePrice.requestid) || !equals((Object) this.shopid, (Object) revisePrice.shopid) || !equals((Object) this.orderid, (Object) revisePrice.orderid) || !equals((Object) this.shipping_fee, (Object) revisePrice.shipping_fee) || !equals((Object) this.token, (Object) revisePrice.token) || !equals((Object) this.bparam, (Object) revisePrice.bparam)) {
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
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.shipping_fee;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RevisePrice> {
        public BackendParam bparam;
        public Long orderid;
        public String requestid;
        public Long shipping_fee;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(RevisePrice revisePrice) {
            super(revisePrice);
            if (revisePrice != null) {
                this.requestid = revisePrice.requestid;
                this.shopid = revisePrice.shopid;
                this.orderid = revisePrice.orderid;
                this.shipping_fee = revisePrice.shipping_fee;
                this.token = revisePrice.token;
                this.bparam = revisePrice.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder shipping_fee(Long l) {
            this.shipping_fee = l;
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

        public RevisePrice build() {
            return new RevisePrice(this);
        }
    }
}
