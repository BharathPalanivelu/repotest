package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CancelReturn extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public CancelReturn(String str, Integer num, Long l, String str2) {
        this.requestid = str;
        this.shopid = num;
        this.return_id = l;
        this.token = str2;
    }

    private CancelReturn(Builder builder) {
        this(builder.requestid, builder.shopid, builder.return_id, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelReturn)) {
            return false;
        }
        CancelReturn cancelReturn = (CancelReturn) obj;
        if (!equals((Object) this.requestid, (Object) cancelReturn.requestid) || !equals((Object) this.shopid, (Object) cancelReturn.shopid) || !equals((Object) this.return_id, (Object) cancelReturn.return_id) || !equals((Object) this.token, (Object) cancelReturn.token)) {
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
        Long l = this.return_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CancelReturn> {
        public String requestid;
        public Long return_id;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(CancelReturn cancelReturn) {
            super(cancelReturn);
            if (cancelReturn != null) {
                this.requestid = cancelReturn.requestid;
                this.shopid = cancelReturn.shopid;
                this.return_id = cancelReturn.return_id;
                this.token = cancelReturn.token;
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

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public CancelReturn build() {
            return new CancelReturn(this);
        }
    }
}
