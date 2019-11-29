package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseUsernum extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_USERNUM = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer usernum;

    public ResponseUsernum(String str, Integer num, Integer num2, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.usernum = num2;
        this.country = str2;
    }

    private ResponseUsernum(Builder builder) {
        this(builder.requestid, builder.errcode, builder.usernum, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUsernum)) {
            return false;
        }
        ResponseUsernum responseUsernum = (ResponseUsernum) obj;
        if (!equals((Object) this.requestid, (Object) responseUsernum.requestid) || !equals((Object) this.errcode, (Object) responseUsernum.errcode) || !equals((Object) this.usernum, (Object) responseUsernum.usernum) || !equals((Object) this.country, (Object) responseUsernum.country)) {
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
        Integer num2 = this.usernum;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseUsernum> {
        public String country;
        public Integer errcode;
        public String requestid;
        public Integer usernum;

        public Builder() {
        }

        public Builder(ResponseUsernum responseUsernum) {
            super(responseUsernum);
            if (responseUsernum != null) {
                this.requestid = responseUsernum.requestid;
                this.errcode = responseUsernum.errcode;
                this.usernum = responseUsernum.usernum;
                this.country = responseUsernum.country;
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

        public Builder usernum(Integer num) {
            this.usernum = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public ResponseUsernum build() {
            checkRequiredFields();
            return new ResponseUsernum(this);
        }
    }
}
