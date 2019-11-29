package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseToken extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public ResponseToken(String str, Integer num, String str2, String str3) {
        this.requestid = str;
        this.errcode = num;
        this.token = str2;
        this.debug_msg = str3;
    }

    private ResponseToken(Builder builder) {
        this(builder.requestid, builder.errcode, builder.token, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseToken)) {
            return false;
        }
        ResponseToken responseToken = (ResponseToken) obj;
        if (!equals((Object) this.requestid, (Object) responseToken.requestid) || !equals((Object) this.errcode, (Object) responseToken.errcode) || !equals((Object) this.token, (Object) responseToken.token) || !equals((Object) this.debug_msg, (Object) responseToken.debug_msg)) {
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
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.debug_msg;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseToken> {
        public String debug_msg;
        public Integer errcode;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ResponseToken responseToken) {
            super(responseToken);
            if (responseToken != null) {
                this.requestid = responseToken.requestid;
                this.errcode = responseToken.errcode;
                this.token = responseToken.token;
                this.debug_msg = responseToken.debug_msg;
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

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponseToken build() {
            return new ResponseToken(this);
        }
    }
}
