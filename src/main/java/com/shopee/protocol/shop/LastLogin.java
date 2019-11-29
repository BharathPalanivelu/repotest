package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LastLogin extends Message {
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_IP = "";
    public static final Integer DEFAULT_LAST_LOGIN = 0;
    public static final String DEFAULT_LOGIN_FROM = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String ip;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer last_login;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String login_from;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public LastLogin(Integer num, Integer num2, String str, Integer num3, String str2) {
        this.id = num;
        this.userid = num2;
        this.login_from = str;
        this.last_login = num3;
        this.ip = str2;
    }

    private LastLogin(Builder builder) {
        this(builder.id, builder.userid, builder.login_from, builder.last_login, builder.ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LastLogin)) {
            return false;
        }
        LastLogin lastLogin = (LastLogin) obj;
        if (!equals((Object) this.id, (Object) lastLogin.id) || !equals((Object) this.userid, (Object) lastLogin.userid) || !equals((Object) this.login_from, (Object) lastLogin.login_from) || !equals((Object) this.last_login, (Object) lastLogin.last_login) || !equals((Object) this.ip, (Object) lastLogin.ip)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.login_from;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.last_login;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.ip;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LastLogin> {
        public Integer id;
        public String ip;
        public Integer last_login;
        public String login_from;
        public Integer userid;

        public Builder() {
        }

        public Builder(LastLogin lastLogin) {
            super(lastLogin);
            if (lastLogin != null) {
                this.id = lastLogin.id;
                this.userid = lastLogin.userid;
                this.login_from = lastLogin.login_from;
                this.last_login = lastLogin.last_login;
                this.ip = lastLogin.ip;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder login_from(String str) {
            this.login_from = str;
            return this;
        }

        public Builder last_login(Integer num) {
            this.last_login = num;
            return this;
        }

        public Builder ip(String str) {
            this.ip = str;
            return this;
        }

        public LastLogin build() {
            return new LastLogin(this);
        }
    }
}
