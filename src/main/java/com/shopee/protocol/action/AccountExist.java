package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AccountExist extends Message {
    public static final Boolean DEFAULT_CHECK_HAS_PWD = false;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean check_has_pwd;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public AccountExist(String str, String str2, String str3, String str4, Boolean bool) {
        this.requestid = str;
        this.phone = str2;
        this.email = str3;
        this.country = str4;
        this.check_has_pwd = bool;
    }

    private AccountExist(Builder builder) {
        this(builder.requestid, builder.phone, builder.email, builder.country, builder.check_has_pwd);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountExist)) {
            return false;
        }
        AccountExist accountExist = (AccountExist) obj;
        if (!equals((Object) this.requestid, (Object) accountExist.requestid) || !equals((Object) this.phone, (Object) accountExist.phone) || !equals((Object) this.email, (Object) accountExist.email) || !equals((Object) this.country, (Object) accountExist.country) || !equals((Object) this.check_has_pwd, (Object) accountExist.check_has_pwd)) {
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
        String str2 = this.phone;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.email;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.country;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.check_has_pwd;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AccountExist> {
        public Boolean check_has_pwd;
        public String country;
        public String email;
        public String phone;
        public String requestid;

        public Builder() {
        }

        public Builder(AccountExist accountExist) {
            super(accountExist);
            if (accountExist != null) {
                this.requestid = accountExist.requestid;
                this.phone = accountExist.phone;
                this.email = accountExist.email;
                this.country = accountExist.country;
                this.check_has_pwd = accountExist.check_has_pwd;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder check_has_pwd(Boolean bool) {
            this.check_has_pwd = bool;
            return this;
        }

        public AccountExist build() {
            return new AccountExist(this);
        }
    }
}
