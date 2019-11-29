package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetReturn extends Message {
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetReturn(String str, String str2, Long l, Boolean bool, Long l2, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.return_id = l;
        this.is_seller = bool;
        this.orderid = l2;
        this.bparam = backendParam;
    }

    private GetReturn(Builder builder) {
        this(builder.requestid, builder.token, builder.return_id, builder.is_seller, builder.orderid, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetReturn)) {
            return false;
        }
        GetReturn getReturn = (GetReturn) obj;
        if (!equals((Object) this.requestid, (Object) getReturn.requestid) || !equals((Object) this.token, (Object) getReturn.token) || !equals((Object) this.return_id, (Object) getReturn.return_id) || !equals((Object) this.is_seller, (Object) getReturn.is_seller) || !equals((Object) this.orderid, (Object) getReturn.orderid) || !equals((Object) this.bparam, (Object) getReturn.bparam)) {
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
        Long l = this.return_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.is_seller;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetReturn> {
        public BackendParam bparam;
        public Boolean is_seller;
        public Long orderid;
        public String requestid;
        public Long return_id;
        public String token;

        public Builder() {
        }

        public Builder(GetReturn getReturn) {
            super(getReturn);
            if (getReturn != null) {
                this.requestid = getReturn.requestid;
                this.token = getReturn.token;
                this.return_id = getReturn.return_id;
                this.is_seller = getReturn.is_seller;
                this.orderid = getReturn.orderid;
                this.bparam = getReturn.bparam;
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

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder is_seller(Boolean bool) {
            this.is_seller = bool;
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

        public GetReturn build() {
            return new GetReturn(this);
        }
    }
}
