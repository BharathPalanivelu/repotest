package com.shopee.protocol.action;

import com.shopee.protocol.shop.Account;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseLineLogin extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_ERRMESSAGE = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8)
    public final Account acc;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String errmessage;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public ResponseLineLogin(String str, Integer num, String str2, String str3, Integer num2, Integer num3, String str4, Account account, Integer num4) {
        this.requestid = str;
        this.errcode = num;
        this.errmessage = str2;
        this.token = str3;
        this.userid = num2;
        this.shopid = num3;
        this.country = str4;
        this.acc = account;
        this.timestamp = num4;
    }

    private ResponseLineLogin(Builder builder) {
        this(builder.requestid, builder.errcode, builder.errmessage, builder.token, builder.userid, builder.shopid, builder.country, builder.acc, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseLineLogin)) {
            return false;
        }
        ResponseLineLogin responseLineLogin = (ResponseLineLogin) obj;
        if (!equals((Object) this.requestid, (Object) responseLineLogin.requestid) || !equals((Object) this.errcode, (Object) responseLineLogin.errcode) || !equals((Object) this.errmessage, (Object) responseLineLogin.errmessage) || !equals((Object) this.token, (Object) responseLineLogin.token) || !equals((Object) this.userid, (Object) responseLineLogin.userid) || !equals((Object) this.shopid, (Object) responseLineLogin.shopid) || !equals((Object) this.country, (Object) responseLineLogin.country) || !equals((Object) this.acc, (Object) responseLineLogin.acc) || !equals((Object) this.timestamp, (Object) responseLineLogin.timestamp)) {
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
        String str2 = this.errmessage;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str4 = this.country;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Account account = this.acc;
        int hashCode8 = (hashCode7 + (account != null ? account.hashCode() : 0)) * 37;
        Integer num4 = this.timestamp;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseLineLogin> {
        public Account acc;
        public String country;
        public Integer errcode;
        public String errmessage;
        public String requestid;
        public Integer shopid;
        public Integer timestamp;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(ResponseLineLogin responseLineLogin) {
            super(responseLineLogin);
            if (responseLineLogin != null) {
                this.requestid = responseLineLogin.requestid;
                this.errcode = responseLineLogin.errcode;
                this.errmessage = responseLineLogin.errmessage;
                this.token = responseLineLogin.token;
                this.userid = responseLineLogin.userid;
                this.shopid = responseLineLogin.shopid;
                this.country = responseLineLogin.country;
                this.acc = responseLineLogin.acc;
                this.timestamp = responseLineLogin.timestamp;
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

        public Builder errmessage(String str) {
            this.errmessage = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder acc(Account account) {
            this.acc = account;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public ResponseLineLogin build() {
            return new ResponseLineLogin(this);
        }
    }
}
