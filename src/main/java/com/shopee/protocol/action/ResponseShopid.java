package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseShopid extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userid;

    public ResponseShopid(String str, Integer num, Integer num2, Integer num3) {
        this.requestid = str;
        this.errcode = num;
        this.shopid = num2;
        this.userid = num3;
    }

    private ResponseShopid(Builder builder) {
        this(builder.requestid, builder.errcode, builder.shopid, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseShopid)) {
            return false;
        }
        ResponseShopid responseShopid = (ResponseShopid) obj;
        if (!equals((Object) this.requestid, (Object) responseShopid.requestid) || !equals((Object) this.errcode, (Object) responseShopid.errcode) || !equals((Object) this.shopid, (Object) responseShopid.shopid) || !equals((Object) this.userid, (Object) responseShopid.userid)) {
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
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseShopid> {
        public Integer errcode;
        public String requestid;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(ResponseShopid responseShopid) {
            super(responseShopid);
            if (responseShopid != null) {
                this.requestid = responseShopid.requestid;
                this.errcode = responseShopid.errcode;
                this.shopid = responseShopid.shopid;
                this.userid = responseShopid.userid;
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

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public ResponseShopid build() {
            checkRequiredFields();
            return new ResponseShopid(this);
        }
    }
}
