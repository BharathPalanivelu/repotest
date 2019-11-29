package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetTransDetail extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public GetTransDetail(String str, Long l, Integer num, String str2, BackendParam backendParam) {
        this.requestid = str;
        this.orderid = l;
        this.shopid = num;
        this.token = str2;
        this.bparam = backendParam;
    }

    private GetTransDetail(Builder builder) {
        this(builder.requestid, builder.orderid, builder.shopid, builder.token, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetTransDetail)) {
            return false;
        }
        GetTransDetail getTransDetail = (GetTransDetail) obj;
        if (!equals((Object) this.requestid, (Object) getTransDetail.requestid) || !equals((Object) this.orderid, (Object) getTransDetail.orderid) || !equals((Object) this.shopid, (Object) getTransDetail.shopid) || !equals((Object) this.token, (Object) getTransDetail.token) || !equals((Object) this.bparam, (Object) getTransDetail.bparam)) {
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
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetTransDetail> {
        public BackendParam bparam;
        public Long orderid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(GetTransDetail getTransDetail) {
            super(getTransDetail);
            if (getTransDetail != null) {
                this.requestid = getTransDetail.requestid;
                this.orderid = getTransDetail.orderid;
                this.shopid = getTransDetail.shopid;
                this.token = getTransDetail.token;
                this.bparam = getTransDetail.bparam;
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

        public Builder shopid(Integer num) {
            this.shopid = num;
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

        public GetTransDetail build() {
            checkRequiredFields();
            return new GetTransDetail(this);
        }
    }
}
