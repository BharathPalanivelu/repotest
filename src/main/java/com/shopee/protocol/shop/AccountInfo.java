package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AccountInfo extends Message {
    public static final Integer DEFAULT_FOLLOWING_COUNT = 0;
    public static final Integer DEFAULT_LAST_LOGIN = 0;
    public static final Integer DEFAULT_LAST_LOGOUT = 0;
    public static final Integer DEFAULT_LIKED_COUNT = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final Integer DEFAULT_WEB_LAST_LOGIN = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer following_count;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer last_login;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer last_logout;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer liked_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer web_last_login;

    public AccountInfo(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.userid = num;
        this.following_count = num2;
        this.liked_count = num3;
        this.last_logout = num4;
        this.last_login = num5;
        this.web_last_login = num6;
    }

    private AccountInfo(Builder builder) {
        this(builder.userid, builder.following_count, builder.liked_count, builder.last_logout, builder.last_login, builder.web_last_login);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountInfo)) {
            return false;
        }
        AccountInfo accountInfo = (AccountInfo) obj;
        if (!equals((Object) this.userid, (Object) accountInfo.userid) || !equals((Object) this.following_count, (Object) accountInfo.following_count) || !equals((Object) this.liked_count, (Object) accountInfo.liked_count) || !equals((Object) this.last_logout, (Object) accountInfo.last_logout) || !equals((Object) this.last_login, (Object) accountInfo.last_login) || !equals((Object) this.web_last_login, (Object) accountInfo.web_last_login)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.following_count;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.liked_count;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.last_logout;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.last_login;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.web_last_login;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AccountInfo> {
        public Integer following_count;
        public Integer last_login;
        public Integer last_logout;
        public Integer liked_count;
        public Integer userid;
        public Integer web_last_login;

        public Builder() {
        }

        public Builder(AccountInfo accountInfo) {
            super(accountInfo);
            if (accountInfo != null) {
                this.userid = accountInfo.userid;
                this.following_count = accountInfo.following_count;
                this.liked_count = accountInfo.liked_count;
                this.last_logout = accountInfo.last_logout;
                this.last_login = accountInfo.last_login;
                this.web_last_login = accountInfo.web_last_login;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder following_count(Integer num) {
            this.following_count = num;
            return this;
        }

        public Builder liked_count(Integer num) {
            this.liked_count = num;
            return this;
        }

        public Builder last_logout(Integer num) {
            this.last_logout = num;
            return this;
        }

        public Builder last_login(Integer num) {
            this.last_login = num;
            return this;
        }

        public Builder web_last_login(Integer num) {
            this.web_last_login = num;
            return this;
        }

        public AccountInfo build() {
            return new AccountInfo(this);
        }
    }
}
