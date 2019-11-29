package com.shopee.protocol.action;

import com.shopee.protocol.shop.Account;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseAppleLogin extends Message {
    public static final String DEFAULT_APPLE_ID = "";
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final Account acc;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String apple_id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public ResponseAppleLogin(String str, Integer num, String str2, String str3, Account account, String str4) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.token = str3;
        this.acc = account;
        this.apple_id = str4;
    }

    private ResponseAppleLogin(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.token, builder.acc, builder.apple_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAppleLogin)) {
            return false;
        }
        ResponseAppleLogin responseAppleLogin = (ResponseAppleLogin) obj;
        if (!equals((Object) this.requestid, (Object) responseAppleLogin.requestid) || !equals((Object) this.errcode, (Object) responseAppleLogin.errcode) || !equals((Object) this.debug_msg, (Object) responseAppleLogin.debug_msg) || !equals((Object) this.token, (Object) responseAppleLogin.token) || !equals((Object) this.acc, (Object) responseAppleLogin.acc) || !equals((Object) this.apple_id, (Object) responseAppleLogin.apple_id)) {
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
        String str2 = this.debug_msg;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Account account = this.acc;
        int hashCode5 = (hashCode4 + (account != null ? account.hashCode() : 0)) * 37;
        String str4 = this.apple_id;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseAppleLogin> {
        public Account acc;
        public String apple_id;
        public String debug_msg;
        public Integer errcode;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ResponseAppleLogin responseAppleLogin) {
            super(responseAppleLogin);
            if (responseAppleLogin != null) {
                this.requestid = responseAppleLogin.requestid;
                this.errcode = responseAppleLogin.errcode;
                this.debug_msg = responseAppleLogin.debug_msg;
                this.token = responseAppleLogin.token;
                this.acc = responseAppleLogin.acc;
                this.apple_id = responseAppleLogin.apple_id;
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

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder acc(Account account) {
            this.acc = account;
            return this;
        }

        public Builder apple_id(String str) {
            this.apple_id = str;
            return this;
        }

        public ResponseAppleLogin build() {
            return new ResponseAppleLogin(this);
        }
    }
}
