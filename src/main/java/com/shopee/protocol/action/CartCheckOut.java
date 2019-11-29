package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartCheckOut extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public CartCheckOut(String str, Integer num, String str2, BackendParam backendParam) {
        this.requestid = str;
        this.shopid = num;
        this.token = str2;
        this.bparam = backendParam;
    }

    private CartCheckOut(Builder builder) {
        this(builder.requestid, builder.shopid, builder.token, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartCheckOut)) {
            return false;
        }
        CartCheckOut cartCheckOut = (CartCheckOut) obj;
        if (!equals((Object) this.requestid, (Object) cartCheckOut.requestid) || !equals((Object) this.shopid, (Object) cartCheckOut.shopid) || !equals((Object) this.token, (Object) cartCheckOut.token) || !equals((Object) this.bparam, (Object) cartCheckOut.bparam)) {
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

    public static final class Builder extends Message.Builder<CartCheckOut> {
        public BackendParam bparam;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(CartCheckOut cartCheckOut) {
            super(cartCheckOut);
            if (cartCheckOut != null) {
                this.requestid = cartCheckOut.requestid;
                this.shopid = cartCheckOut.shopid;
                this.token = cartCheckOut.token;
                this.bparam = cartCheckOut.bparam;
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public CartCheckOut build() {
            checkRequiredFields();
            return new CartCheckOut(this);
        }
    }
}
