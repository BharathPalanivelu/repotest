package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DelAddress extends Message {
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public DelAddress(String str, String str2, Integer num, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.id = num;
        this.bparam = backendParam;
    }

    private DelAddress(Builder builder) {
        this(builder.requestid, builder.token, builder.id, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DelAddress)) {
            return false;
        }
        DelAddress delAddress = (DelAddress) obj;
        if (!equals((Object) this.requestid, (Object) delAddress.requestid) || !equals((Object) this.token, (Object) delAddress.token) || !equals((Object) this.id, (Object) delAddress.id) || !equals((Object) this.bparam, (Object) delAddress.bparam)) {
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
        Integer num = this.id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DelAddress> {
        public BackendParam bparam;
        public Integer id;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(DelAddress delAddress) {
            super(delAddress);
            if (delAddress != null) {
                this.requestid = delAddress.requestid;
                this.token = delAddress.token;
                this.id = delAddress.id;
                this.bparam = delAddress.bparam;
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

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public DelAddress build() {
            checkRequiredFields();
            return new DelAddress(this);
        }
    }
}
